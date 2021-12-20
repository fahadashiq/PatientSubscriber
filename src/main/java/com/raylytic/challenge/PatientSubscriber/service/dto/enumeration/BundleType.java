package com.raylytic.challenge.PatientSubscriber.service.dto.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

public enum BundleType
{
  DOCUMENT("document"),
  MESSAGE("message"),
  TRANSACTION("transaction"),
  TRANSACTION_RESPONSE("transaction-response"),
  BATCH("batch"),
  BATCH_RESPONSE("batch-response"),
  HISTORY("history"),
  SEARCHSET("searchset"),
  COLLECTION("collection");

  private String value;
  BundleType(String value)
  {
    this.value = value;
  }

  @JsonValue
  @Override
  public String toString() {
    return this.value;
  }

}
