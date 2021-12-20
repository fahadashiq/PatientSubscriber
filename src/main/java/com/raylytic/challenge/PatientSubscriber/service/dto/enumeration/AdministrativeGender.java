package com.raylytic.challenge.PatientSubscriber.service.dto.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Genders as per ANSI standards.
 */
public enum AdministrativeGender
{
  MALE("male"),
  FEMALE("female"),
  OTHER("other"),
  UNKNOWN("unknown");

  private String value;

  AdministrativeGender(String value) {
    this.value = value;
  }

  @JsonValue
  @Override
  public String toString() {
    return this.value;
  }
}
