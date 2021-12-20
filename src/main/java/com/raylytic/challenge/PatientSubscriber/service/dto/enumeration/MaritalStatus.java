package com.raylytic.challenge.PatientSubscriber.service.dto.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Marital Statuses as per ANSI standards.
 */
public enum MaritalStatus
{
  ANNULLED("Annulled"),
  DIVORCED("Divorced"),
  INTERLOCUTORY("Interlocutory"),
  LEGALLY_SEPARATED("Legally Separated"),
  MARRIED("Married"),
  POLYGAMOUS("Polygamous"),
  NEVER_MARRIED("Never Married"),
  DOMESTIC_PARTNER("Domestic partner"),
  UNMARRIED("unmarried"),
  WIDOWED("Widowed"),
  UNKNOWN("unknown");

  private String value;

  MaritalStatus(String value) {
    this.value = value;
  }

  @JsonValue
  @Override
  public String toString() {
    return this.value;
  }
}
