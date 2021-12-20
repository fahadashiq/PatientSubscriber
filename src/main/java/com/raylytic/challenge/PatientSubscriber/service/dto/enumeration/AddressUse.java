package com.raylytic.challenge.PatientSubscriber.service.dto.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

public enum AddressUse
{
  HOME("home"),
  WORK("work"),
  TEMPORARY("temp"),
  OLD_OR_INCORRECT("old"),
  BILLING("billing");

  private String value;
  AddressUse(String value)
  {
    this.value = value;
  }

  @JsonValue
  @Override
  public String toString() {
    return this.value;
  }

}
