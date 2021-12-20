package com.raylytic.challenge.PatientSubscriber.service.dto.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

public enum AddressType
{
  POSTAL("postal"),
  PHYSICAL("physical"),
  POSTAL_AND_PHYSICAL("both");

  private String value;
  AddressType(String value)
  {
    this.value = value;
  }

  @JsonValue
  @Override
  public String toString() {
    return this.value;
  }
}
