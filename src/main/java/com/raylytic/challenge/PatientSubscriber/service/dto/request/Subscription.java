package com.raylytic.challenge.PatientSubscriber.service.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.raylytic.challenge.PatientSubscriber.service.dto.enumeration.ResourceType;
import com.raylytic.challenge.PatientSubscriber.service.dto.enumeration.SubscriptionStatus;
import com.raylytic.challenge.PatientSubscriber.service.dto.DomainResource;
import com.raylytic.challenge.PatientSubscriber.service.dto.request.generic.ContactPoint;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Subscription extends DomainResource
{
  //@Pattern(regexp = "[^\\s]+(\\s[^\\s]+)*")
  //private String status;

  @NotNull
  private SubscriptionStatus status;
  private List<ContactPoint> contact;
  private Instant end;
  @NotBlank
  private String reason;
  @NotBlank
  private String criteria;
  private String error;
  @NotNull
  private Channel channel;


  @Override
  public ResourceType getResourceType()
  {
    return ResourceType.SUBSCRIPTION;
  }
}
