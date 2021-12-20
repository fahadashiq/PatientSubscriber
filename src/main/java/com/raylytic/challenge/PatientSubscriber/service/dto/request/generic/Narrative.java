package com.raylytic.challenge.PatientSubscriber.service.dto.request.generic;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.raylytic.challenge.PatientSubscriber.service.dto.enumeration.NarrativeStatus;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Narrative
{
  @NotNull
  private NarrativeStatus status;
  @NotBlank
  private String div;
}