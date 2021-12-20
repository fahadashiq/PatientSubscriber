package com.raylytic.challenge.PatientSubscriber.service.dto.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Marital Statuses as per ANSI standards.
 */
public enum NameUse
{
  USUAL("usual"),
  DIVORCED("Divorced"),
  OFFICIAL("official"),
  TEMP("temp"),
  NICKNAME("nickname"),
  ANONYMOUS("anonymous"),
  OLD("old"),
  NAME_CHANGED_FOR_MARRIAGE("maiden");

  private String value;

  NameUse(String value) {
    this.value = value;
  }

  @JsonValue
  @Override
  public String toString() {
    return this.value;
  }
}
