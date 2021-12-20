package com.raylytic.challenge.PatientSubscriber.service.dto.request.generic;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.raylytic.challenge.PatientSubscriber.service.dto.enumeration.NameUse;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class HumanName
{
  private NameUse use;
  private String text;
  private String family;
  private List<String> given;
  private List<String> prefix;
  private List<String> suffix;
  private Period period;

}
