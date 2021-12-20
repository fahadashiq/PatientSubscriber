package com.raylytic.challenge.PatientSubscriber.controller;

import com.raylytic.challenge.PatientSubscriber.service.dto.request.Patient;
import com.raylytic.challenge.PatientSubscriber.service.patient.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Rest controller to handle patient resources.
 */
@RestController
@RequestMapping("/patient")
public class PatientController
{
  private final Logger logger = LoggerFactory.getLogger(PatientController.class);
  @Autowired
  private PatientService patientService;


  @Operation(summary = "Post a new patient resource.")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Patient resource created successfully.",
                  content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Patient.class))})
  })
  @RequestMapping(path = "/publish", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Patient> publishPatientRecord(@Valid @RequestBody Patient patient) {
    Patient result = patientService.createPatientRecord(patient);
    return ResponseEntity
            .ok()
            .body(result);
  }

  @Operation(summary = "Used to notify in case a new patient resource is created.")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Logged successfully.", content = {@Content(mediaType = "application/json")})
  })
  @PostMapping("/subscribed")
  public ResponseEntity onPatientCreate() {
    logger.info("A new Patient resource has been created.");
    return ResponseEntity
            .ok()
            .build();
  }

}
