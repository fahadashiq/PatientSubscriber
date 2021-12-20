package com.raylytic.challenge.PatientSubscriber.service.dto.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Marital Statuses as per ANSI standards.
 */
public enum NarrativeStatus
{
  GENERATED("generated"),
  EXTENSIONS("extensions"),
  ADDITIONAL("additional"),
  EMPTY("empty");

  private String value;

  NarrativeStatus(String value) {
    this.value = value;
  }

  @JsonValue
  @Override
  public String toString() {
    return this.value;
  }
}
