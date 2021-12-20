package com.raylytic.challenge.PatientSubscriber.service.patient;

import com.raylytic.challenge.PatientSubscriber.service.dto.enumeration.AdministrativeGender;
import com.raylytic.challenge.PatientSubscriber.service.dto.request.Patient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * Test class for {@link PatientService}
 */
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class PatientServiceTest
{
  @InjectMocks
  private PatientService patientService;

  @Mock
  private PatientPublishServiceFHIRImpl patientPublishService;

  private Patient request;
  private Patient response;

  @Test
  public void givenValidPatientRecord_isCreated() {
    givenMockedPatientRecord();
    whenCreatePatientIsCalled();
    thenPassedPatientRecordIsCreated();
  }

  private void givenMockedPatientRecord() {
    request = new Patient();
    request.setGender(AdministrativeGender.MALE);
    when(patientPublishService.publishPatientRecord(any())).thenReturn(request);
  }

  private void whenCreatePatientIsCalled() {
    response = patientService.createPatientRecord(request);
  }

  private void thenPassedPatientRecordIsCreated() {
    assertEquals(AdministrativeGender.MALE, response.getGender());
  }

}