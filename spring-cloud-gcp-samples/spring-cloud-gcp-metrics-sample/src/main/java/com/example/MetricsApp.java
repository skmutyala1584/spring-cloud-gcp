package com.example;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MetricsApp {

  public static void main(String[] args) {
    SpringApplication.run(MetricsApp.class, args);
    System.out.println("I am here");
  }

  @Bean
  public CommandLineRunner countMetric(MeterRegistry registry) {
    return (args) -> {
      System.out.println("HELLOOOO");
      registry.config().commonTags("application", "metrics sample");
      registry.counter("elena.test", "externalcontrib", "true");
    };

  }
}
