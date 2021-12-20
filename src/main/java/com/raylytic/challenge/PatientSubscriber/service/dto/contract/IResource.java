package com.raylytic.challenge.PatientSubscriber.service.dto.contract;

import com.raylytic.challenge.PatientSubscriber.service.dto.request.generic.Meta;

public interface IResource
{
  String getId();
  Meta getMeta();
  void setId(String id);
  void setMeta(Meta meta);
}
