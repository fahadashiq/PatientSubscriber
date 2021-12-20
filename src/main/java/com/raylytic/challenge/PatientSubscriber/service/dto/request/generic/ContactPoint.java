package com.raylytic.challenge.PatientSubscriber.service.dto.request.generic;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.raylytic.challenge.PatientSubscriber.service.dto.enumeration.ContactPointSystem;
import com.raylytic.challenge.PatientSubscriber.service.dto.enumeration.ContactPointUse;
import lombok.Data;

import javax.validation.constraints.Min;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContactPoint
{
  private ContactPointSystem system;
  private String value;
  private ContactPointUse use;
  @Min(value = 1, message = "The value must be positive.")
  private Period period;

}
