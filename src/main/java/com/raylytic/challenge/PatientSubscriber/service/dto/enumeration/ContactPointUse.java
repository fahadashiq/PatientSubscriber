package com.raylytic.challenge.PatientSubscriber.service.dto.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ContactPointUse
{
  HOME("home"),
  WORK("work"),
  TEMPORARY("temp"),
  OLD_OR_INCORRECT("old"),
  MOBILE("mobile");

  private String value;
  ContactPointUse(String value)
  {
    this.value = value;
  }

  @JsonValue
  @Override
  public String toString() {
    return this.value;
  }
}
