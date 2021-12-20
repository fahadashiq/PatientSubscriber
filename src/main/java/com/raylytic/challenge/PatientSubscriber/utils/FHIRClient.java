package com.raylytic.challenge.PatientSubscriber.utils;

import com.raylytic.challenge.PatientSubscriber.configs.ApplicationProperties;
import com.raylytic.challenge.PatientSubscriber.service.dto.enumeration.ResourceType;
import com.raylytic.challenge.PatientSubscriber.service.dto.contract.IDomainResource;
import com.raylytic.challenge.PatientSubscriber.service.dto.response.Bundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * A client for FHIR server.
 */
@Service
public class FHIRClient
{
  @Autowired
  private ApplicationProperties applicationProperties;

  @Autowired
  private RestTemplate restTemplate;

  /**
   * Method to post any kind of resource to configured server.
   * @param domainResource resource to publish
   * @return Response entity with with given domain resource as body.
   * @throws ResponseStatusException
   */
  public ResponseEntity postResource(IDomainResource domainResource) throws ResponseStatusException {
    try
    {
      return restTemplate
              .postForEntity(buildURI(domainResource.getResourceType().toString(), new LinkedMultiValueMap<>()),
                      getHttpEntity(domainResource),
                      ResourceType.getResourceClass(domainResource.getResourceType().toString()));
    }
    catch (HttpClientErrorException e) {
      throw new ResponseStatusException(HttpStatus.BAD_GATEWAY,
              String.format("Error from the FHIR server with Response Code: {%s} and Message: {%s}", e.getStatusCode(), e.getMessage()));
    }
    catch (RestClientException e) {
      throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, "Error connecting to the FHIR server.");
    }
    catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "An unexpected error occurred while connecting to FHIR server", e);
    }
  }

  /**
   * Method to get any kind of resource to configured server.
   * @param queryParams query params for get request
   * @param resourceType resource type to query.
   * @return Response entity with with given domain resource as body.
   * @throws ResponseStatusException
   */
  public ResponseEntity getResource(MultiValueMap<String, String> queryParams, ResourceType resourceType) throws ResponseStatusException{
    try {
      return restTemplate.getForEntity(buildURI(resourceType.toString(), queryParams), Bundle.class);
    }
    catch (HttpClientErrorException e) {
      throw new ResponseStatusException(HttpStatus.BAD_GATEWAY,
              String.format("Error from the FHIR server with Response Code: {%s} and Message: {%s}", e.getStatusCode(), e.getMessage()));
    }
    catch (RestClientException e)
    {
      throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, "Error connecting to the FHIR server.");
    }
    catch (Exception e)
    {
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "An unexpected error occurred while connecting to FHIR server", e);
    }
  }

  private HttpEntity getHttpEntity(IDomainResource domainResource) {
    HttpEntity<IDomainResource> httpEntity = new HttpEntity(domainResource, getHeadersForRequest());
    return httpEntity;
  }

  private HttpHeaders getHeadersForRequest() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    return headers;
  }

  private String buildURI(String endpoint, MultiValueMap<String, String> queryParams) {
    return UriComponentsBuilder
            .newInstance()
            .scheme(applicationProperties.getFhirServerConfigs().getScheme())
            .host(applicationProperties.getFhirServerConfigs().getUrl())
            .path(endpoint).queryParams(queryParams)
            .build()
            .toUriString();
  }
}
