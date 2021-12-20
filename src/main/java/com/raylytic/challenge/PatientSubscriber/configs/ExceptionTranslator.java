package com.raylytic.challenge.PatientSubscriber.configs;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.raylytic.challenge.PatientSubscriber.service.dto.ErrorDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * To translate few exceptions into readable message.
 */
@ControllerAdvice
public class ExceptionTranslator
{
  private final Logger logger = LoggerFactory.getLogger(ExceptionTranslator.class);

  /**
   * To translate HttpMessageNotReadableException into meaningful words.
   * @param response
   * @param ex
   * @return
   * @throws IOException
   */
  @ExceptionHandler(HttpMessageNotReadableException.class)
  public ResponseEntity handleHttpMessageNotReadableException(HttpServletResponse response, HttpMessageNotReadableException ex) throws IOException
  {
    if (ex.getCause() instanceof InvalidFormatException) {
      ((InvalidFormatException)ex.getCause()).getTargetType().getSimpleName();
      ((InvalidFormatException)ex.getCause()).getValue();
      String errorMessage = String.format("Bad Value: {%s} for the given Field: {%s}",  ((InvalidFormatException)ex.getCause()).getValue(), ((InvalidFormatException)ex.getCause()).getTargetType().getSimpleName());
      logger.error(errorMessage);
      return ResponseEntity
              .badRequest()
              .body(new ErrorDTO(errorMessage, null));
    }
    return ResponseEntity
            .badRequest()
            .body(new ErrorDTO(ex.getMessage(), null));
  }

  /**
   * To translate ResponseStatusException into meaningful words.
   * @param ex
   * @return
   * @throws IOException
   */
  @ExceptionHandler(ResponseStatusException.class)
  public ResponseEntity handleResponseStatusException(ResponseStatusException ex) throws IOException
  {
    return ResponseEntity
            .status(ex.getStatus())
            .body(new ErrorDTO(ex.getMessage(), ex.getStatus().toString()));
  }
}
