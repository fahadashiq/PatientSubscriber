package com.raylytic.challenge.PatientSubscriber.service.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.raylytic.challenge.PatientSubscriber.service.dto.enumeration.AdministrativeGender;
import com.raylytic.challenge.PatientSubscriber.service.dto.enumeration.MaritalStatus;
import com.raylytic.challenge.PatientSubscriber.service.dto.enumeration.ResourceType;
import com.raylytic.challenge.PatientSubscriber.service.dto.DomainResource;
import com.raylytic.challenge.PatientSubscriber.service.dto.request.generic.Address;
import com.raylytic.challenge.PatientSubscriber.service.dto.request.generic.Attachment;
import com.raylytic.challenge.PatientSubscriber.service.dto.request.generic.Communication;
import com.raylytic.challenge.PatientSubscriber.service.dto.request.generic.Contact;
import com.raylytic.challenge.PatientSubscriber.service.dto.request.generic.ContactPoint;
import com.raylytic.challenge.PatientSubscriber.service.dto.request.generic.HumanName;
import com.raylytic.challenge.PatientSubscriber.service.dto.request.generic.Identifier;
import com.raylytic.challenge.PatientSubscriber.service.dto.request.generic.Link;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Patient extends DomainResource
{
  private List<Identifier> identifier;
  private Boolean active;
  private List<HumanName> name;
  private List<ContactPoint> telecom;
  private AdministrativeGender gender;
  private Instant birthDate;
  private Boolean deceased;
  private List<Address> address;
  private MaritalStatus maritalStatus;
  private Boolean multipleBirth;
  private List<Attachment> photo;
  private List<Contact> contact;
  private List<Communication> communication;
  private List<String> generalPractitioner;
  private String managingOrganization;
  private List<Link> link;

  public ResourceType getResourceType() {
    return ResourceType.PATIENT;
  }
}
