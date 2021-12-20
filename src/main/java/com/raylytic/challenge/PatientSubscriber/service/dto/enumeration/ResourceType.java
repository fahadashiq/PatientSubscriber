package com.raylytic.challenge.PatientSubscriber.service.dto.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;
import com.raylytic.challenge.PatientSubscriber.service.dto.response.Bundle;
import com.raylytic.challenge.PatientSubscriber.service.dto.request.Patient;
import com.raylytic.challenge.PatientSubscriber.service.dto.request.Subscription;

public enum ResourceType {
  BUNDLE("Bundle"),
  PATIENT("Patient"),
  SUBSCRIPTION("Subscription");

  private String value;

  ResourceType(String value) {
    this.value = value;
  }

  @JsonValue
  @Override
  public String toString() {
    return this.value;
  }

  public static Class getResourceClass(String value) {
    if (ResourceType.BUNDLE.value.equals(value)) {
      return Bundle.class;
    }
    else if (ResourceType.SUBSCRIPTION.value.equals(value)) {
      return Subscription.class;
    }
    else if (ResourceType.PATIENT.value.equals(value)) {
      return Patient.class;
    }
    return Object.class;
  }
}
