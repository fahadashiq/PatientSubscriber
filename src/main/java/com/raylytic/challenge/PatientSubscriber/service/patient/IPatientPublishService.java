package com.raylytic.challenge.PatientSubscriber.service.patient;

import com.raylytic.challenge.PatientSubscriber.service.dto.request.Patient;

/**
 * A contract to handle patient records.
 */
public interface IPatientPublishService
{
  /**
   * Published patient record to the implemented client.
   * @param patient record to be published.
   * @return published record.
   */
  Patient publishPatientRecord(Patient patient);
}
