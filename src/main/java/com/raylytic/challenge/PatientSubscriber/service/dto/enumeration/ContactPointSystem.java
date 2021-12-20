package com.raylytic.challenge.PatientSubscriber.service.dto.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ContactPointSystem
{
  PHONE("phone"),
  FAX("fax"),
  EMAIL("email"),
  PAGER("pager"),
  URL("url"),
  SMS("sms"),
  OTHER("other");

  private String value;

  ContactPointSystem(String value) {
    this.value = value;
  }

  @JsonValue
  @Override
  public String toString() {
    return this.value;
  }
}
