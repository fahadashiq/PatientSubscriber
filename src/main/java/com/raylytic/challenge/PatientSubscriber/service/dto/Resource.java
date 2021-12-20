package com.raylytic.challenge.PatientSubscriber.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.raylytic.challenge.PatientSubscriber.service.dto.contract.IResource;
import com.raylytic.challenge.PatientSubscriber.service.dto.request.generic.Meta;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class Resource implements IResource
{
  private String id;
  private Meta meta;
}
