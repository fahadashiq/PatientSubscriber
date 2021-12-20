package com.raylytic.challenge.PatientSubscriber.service.dto.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

public enum SubscriptionStatus
{
  REQUESTED("requested"),
  ACTIVE("active"),
  ERROR("error"),
  OFF("off");

  private String value;

  SubscriptionStatus(String value) {
    this.value = value;
  }

  @JsonValue
  @Override
  public String toString() {
    return this.value;
  }
}
