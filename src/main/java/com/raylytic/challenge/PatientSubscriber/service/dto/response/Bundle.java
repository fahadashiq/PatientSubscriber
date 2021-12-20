package com.raylytic.challenge.PatientSubscriber.service.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.raylytic.challenge.PatientSubscriber.service.dto.enumeration.BundleType;
import com.raylytic.challenge.PatientSubscriber.service.dto.enumeration.ResourceType;
import com.raylytic.challenge.PatientSubscriber.service.dto.DomainResource;
import com.raylytic.challenge.PatientSubscriber.service.dto.request.generic.Entry;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Bundle<E> extends DomainResource
{
  // TODO To be completed.

  private String id;
  private BundleType type;
  private List<Entry<E>> entry;

  @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
  private ZonedDateTime timestamp;

  @Min(0)
  private Integer total;
  private List<Entry<E>> link;


  @Override
  public ResourceType getResourceType()
  {
    return ResourceType.BUNDLE;
  }
}
