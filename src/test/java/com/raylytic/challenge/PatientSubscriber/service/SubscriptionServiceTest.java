package com.raylytic.challenge.PatientSubscriber.service;

import com.raylytic.challenge.PatientSubscriber.service.dto.enumeration.SubscriptionChannelType;
import com.raylytic.challenge.PatientSubscriber.service.dto.enumeration.SubscriptionStatus;
import com.raylytic.challenge.PatientSubscriber.service.dto.request.Channel;
import com.raylytic.challenge.PatientSubscriber.service.dto.request.Subscription;
import com.raylytic.challenge.PatientSubscriber.service.dto.request.generic.Entry;
import com.raylytic.challenge.PatientSubscriber.service.dto.response.Bundle;
import com.raylytic.challenge.PatientSubscriber.utils.FHIRClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * Test class for {@link SubscriptionService}
 */
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class SubscriptionServiceTest
{
  @InjectMocks
  private SubscriptionService subscriptionService;

  @Mock
  private FHIRClient fhirClient;

  private Subscription request;
  private Subscription response;

  @Test
  public void givenValidSubscriptionRecord_isCreated() {
    givenMockedSubscriptionRecord();
    givenNoSubscriptionResourceAlreadyExist();
    whenSubscribeForResourceIsCalled();
    thenPassedSubscriptionRecordIsCreated();
  }

  @Test
  public void givenSubscriptionRecordThatAlreadyExists_exceptionThrown() {
    givenSubscriptionResourceAlreadyExist();
    assertThrows(ResponseStatusException.class, () -> whenSubscribeForResourceIsCalled());
  }

  private void givenNoSubscriptionResourceAlreadyExist() {
    Bundle<Subscription> subscriptionBundle = new Bundle<>();
    ResponseEntity<Bundle<Subscription>> responseEntity = ResponseEntity.ok(subscriptionBundle);
    when(fhirClient.getResource(any(), any())).thenReturn(responseEntity);
  }

  private void givenSubscriptionResourceAlreadyExist() {
    Bundle<Subscription> subscriptionBundle = new Bundle<>();
    List<Entry<Subscription>> entries = new ArrayList<>();
    Entry<Subscription> entry = new Entry<>();
    request = new Subscription();
    request.setCriteria("criteria");
    Channel channel = new Channel();
    channel.setEndpoint("endpoint");
    channel.setType(SubscriptionChannelType.REST_HOOK);
    request.setChannel(channel);
    entry.setResource(request);

    subscriptionBundle.setEntry(entries);
    entries.add(entry);
    ResponseEntity<Bundle<Subscription>> responseEntity = ResponseEntity.ok(subscriptionBundle);
    when(fhirClient.getResource(any(), any())).thenReturn(responseEntity);
  }

  private void givenMockedSubscriptionRecord() {
    request = new Subscription();
    request.setStatus(SubscriptionStatus.ACTIVE);
    ResponseEntity<Subscription> responseEntity = ResponseEntity.ok(request);
    when(fhirClient.postResource(any())).thenReturn(responseEntity);
  }

  private void whenSubscribeForResourceIsCalled() {
    response = subscriptionService.subscribeForResource(request);
  }

  private void thenPassedSubscriptionRecordIsCreated() {
    assertEquals(SubscriptionStatus.ACTIVE, response.getStatus());
  }

}