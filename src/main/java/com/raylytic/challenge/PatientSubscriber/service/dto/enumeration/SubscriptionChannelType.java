package com.raylytic.challenge.PatientSubscriber.service.dto.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

public enum SubscriptionChannelType
{
  REST_HOOK("rest-hook"),
  WEB_SOCKET("websocket"),
  EMAIL("email"),
  SMS("sms"),
  MESSAGE("message");

  private String value;

  SubscriptionChannelType(String value) {
    this.value = value;
  }

  @JsonValue
  @Override
  public String toString() {
    return this.value;
  }
}
