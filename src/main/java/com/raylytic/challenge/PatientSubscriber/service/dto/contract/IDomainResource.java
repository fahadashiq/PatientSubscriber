package com.raylytic.challenge.PatientSubscriber.service.dto.contract;

import com.raylytic.challenge.PatientSubscriber.service.dto.enumeration.ResourceType;
import com.raylytic.challenge.PatientSubscriber.service.dto.request.generic.Narrative;

public interface IDomainResource
{
  // :TODO Add all resources.
  ResourceType getResourceType();
  Narrative getText();
  void setText(Narrative narrative);
}
