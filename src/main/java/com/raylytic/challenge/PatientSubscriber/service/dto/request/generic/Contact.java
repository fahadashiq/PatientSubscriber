package com.raylytic.challenge.PatientSubscriber.service.dto.request.generic;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.raylytic.challenge.PatientSubscriber.service.dto.enumeration.ContactRelationship;
import com.raylytic.challenge.PatientSubscriber.service.dto.enumeration.AdministrativeGender;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Contact
{
  // Not complete.
  private List<ContactRelationship> relationship;
  private HumanName name;
  private List<ContactPoint> telecom;
  private Address address;
  private AdministrativeGender gender;
}
