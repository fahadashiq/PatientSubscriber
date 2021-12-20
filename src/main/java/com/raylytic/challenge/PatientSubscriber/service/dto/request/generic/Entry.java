package com.raylytic.challenge.PatientSubscriber.service.dto.request.generic;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import com.raylytic.challenge.PatientSubscriber.service.dto.enumeration.ResourceType;
import lombok.Data;

import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Entry<E>
{
  private String fullUrl;
  private E resource;


  public void setResource(E resource) {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.registerModule(new JSR310Module());
    if (resource instanceof Map) {
      Map<String, String> resourceMap = (Map) resource;
      this.resource = (E) objectMapper.convertValue(resource,  ResourceType.getResourceClass(resourceMap.get("resourceType")));
    }
    else {
      this.resource = resource;
    }
  }


  // TODO to be completed.
}
