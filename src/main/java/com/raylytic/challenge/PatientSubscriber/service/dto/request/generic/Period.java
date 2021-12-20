package com.raylytic.challenge.PatientSubscriber.service.dto.request.generic;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.Instant;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Period
{
  private Instant start;
  private Instant end;
}
