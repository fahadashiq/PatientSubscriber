package com.raylytic.challenge.PatientSubscriber.controller;

import com.raylytic.challenge.PatientSubscriber.service.SubscriptionService;
import com.raylytic.challenge.PatientSubscriber.service.dto.request.Patient;
import com.raylytic.challenge.PatientSubscriber.service.dto.request.Subscription;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Rest controller to handle subscriptions.
 */
@RestController
@RequestMapping("/subscription")
public class ResourceSubscriptionController
{
  @Autowired
  private SubscriptionService subscriptionService;

  @Operation(summary = "Subscribe to any resource.")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Resource Subscribed successfully.",
                  content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Patient.class))})
  })
  @PostMapping("/subscribe")
  public ResponseEntity<Subscription> subscribeForResource(@Valid @RequestBody Subscription subscription) {
    Subscription response = subscriptionService.subscribeForResource(subscription);
    return ResponseEntity
            .ok()
            .body(response);
  }

}
