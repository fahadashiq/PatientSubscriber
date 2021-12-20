package com.raylytic.challenge.PatientSubscriber.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A simple dto to return in case of exceptions.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDTO
{
  private String message;
  private String statusCode;
}
