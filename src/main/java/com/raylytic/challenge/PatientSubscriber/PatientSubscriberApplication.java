package com.raylytic.challenge.PatientSubscriber;

import com.raylytic.challenge.PatientSubscriber.configs.ApplicationProperties;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Patient Subscriber", version = "1.0.0", description = "Subscribes to patient creation events"))
@EnableConfigurationProperties({ ApplicationProperties.class })
public class PatientSubscriberApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientSubscriberApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

}
