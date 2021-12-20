package com.raylytic.challenge.PatientSubscriber.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.raylytic.challenge.PatientSubscriber.service.dto.contract.IDomainResource;
import com.raylytic.challenge.PatientSubscriber.service.dto.request.generic.Narrative;
import lombok.Data;

/**
 * Domain resource class for all resources to extend.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class DomainResource extends Resource implements IDomainResource
{
  // :TODO Add all resources.
  private Narrative text;

}
