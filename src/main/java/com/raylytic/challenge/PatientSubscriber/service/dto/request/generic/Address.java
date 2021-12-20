package com.raylytic.challenge.PatientSubscriber.service.dto.request.generic;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.raylytic.challenge.PatientSubscriber.service.dto.enumeration.AddressType;
import com.raylytic.challenge.PatientSubscriber.service.dto.enumeration.AddressUse;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Address
{
  private AddressUse use;
  private AddressType type;
  private String text;
  private List<String> line;
  private String city;
  private String district;
  private String state;
  private String postalCode;
  private String country;
}
