package com.raylytic.challenge.PatientSubscriber.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.env.Environment;

/**
 * Config class to initialize any logging aspects.
 */
@Configuration
@EnableAspectJAutoProxy
public class LoggingAspectConfiguration
{
    @Bean
    public LoggingAspect loggingAspect(Environment env) {
        return new LoggingAspect(env);
    }

}
