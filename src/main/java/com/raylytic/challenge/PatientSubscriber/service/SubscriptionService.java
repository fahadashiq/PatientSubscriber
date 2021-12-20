package com.raylytic.challenge.PatientSubscriber.service;

import com.raylytic.challenge.PatientSubscriber.service.dto.enumeration.ResourceType;
import com.raylytic.challenge.PatientSubscriber.service.dto.request.Subscription;
import com.raylytic.challenge.PatientSubscriber.service.dto.response.Bundle;
import com.raylytic.challenge.PatientSubscriber.utils.FHIRClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ResponseStatusException;

/**
 * Business class for subscription resource.
 */
@Service
public class SubscriptionService
{
  @Autowired
  private FHIRClient fhirClient;

  /**
   * To subscribe to a resource.
   * @param subscription subscription to be enabled.
   * @return subscribed object.
   */
  public Subscription subscribeForResource(Subscription subscription) {
    checkIfAlreadySubscribed(subscription);
    ResponseEntity responseEntity = fhirClient.postResource(subscription);
    return (Subscription) responseEntity.getBody();
  }

  private void checkIfAlreadySubscribed(Subscription subscription) {
    MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
    queryParams.add("criteria", subscription.getCriteria());
    ResponseEntity response = fhirClient.getResource(queryParams, ResourceType.SUBSCRIPTION);
    Bundle<Subscription> bundle = (Bundle<Subscription>) response.getBody();
    if (bundle != null && bundle.getEntry() != null) {
      bundle.getEntry().forEach(entry -> {
        if (entry != null && entry.getResource() != null && entry.getResource().getChannel() != null) {
          if (entry.getResource().getChannel().getType().equals(subscription.getChannel().getType())
                  && subscription.getChannel().getEndpoint() != null
                  && subscription.getChannel().getEndpoint().equals(entry.getResource().getChannel().getEndpoint())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Already Subscribed to given channel on given criteria.");
          }
        }
      });
    }
  }


}
