package com.raylytic.challenge.PatientSubscriber.service.patient;


import com.raylytic.challenge.PatientSubscriber.service.dto.request.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Business class for patient resource.
 */
@Service
public class PatientService
{
  @Autowired
  private IPatientPublishService patientPublishService;

  /**
   * Method to post patient resource.
   * @param patient patient to post.
   * @return newly created patient record.
   */
  public Patient createPatientRecord(Patient patient) {
    return patientPublishService.publishPatientRecord(patient);
  }

}
