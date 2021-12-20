package com.raylytic.challenge.PatientSubscriber.service.dto.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ContactRelationship
{
  EMERGENCY_CONTACT("C"),
  EMPLOYER("E"),
  FEDERAL_AGENCY("F"),
  INSURANCE_COMPANY("I"),
  NEXT_OF_KIN("N"),
  STATE_AGENCY("S"),
  UNKNOWN("U");

  private String value;

  ContactRelationship(String value) {
    this.value = value;
  }

  @JsonValue
  @Override
  public String toString() {
    return this.value;
  }
}
