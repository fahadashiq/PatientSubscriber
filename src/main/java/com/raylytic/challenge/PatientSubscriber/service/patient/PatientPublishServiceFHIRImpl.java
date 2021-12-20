package com.raylytic.challenge.PatientSubscriber.service.patient;

import com.raylytic.challenge.PatientSubscriber.service.dto.mapper.PatientResponseMapper;
import com.raylytic.challenge.PatientSubscriber.service.dto.request.Patient;
import com.raylytic.challenge.PatientSubscriber.utils.FHIRClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * To publish patient resources to FHIR server.
 */
@Service
public class PatientPublishServiceFHIRImpl implements IPatientPublishService
{
  @Autowired
  private FHIRClient fhirClient;

  //@Autowired
  private PatientResponseMapper patientResponseMapper;

  /**
   * {@inheritDoc}
   */
  public Patient publishPatientRecord(Patient patient) {
    ResponseEntity response = fhirClient.postResource(patient);
    Patient patientResponse = (Patient) response.getBody();
    return patientResponse;
  }

}
