package com.raylytic.challenge.PatientSubscriber.configs;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Class to access configs of the application.
 */
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = true)
@Data
public class ApplicationProperties
{
  private FhirServerConfigs fhirServerConfigs;

  @Data
  public static class FhirServerConfigs {
    private String url;
    private String scheme;
  }
}
