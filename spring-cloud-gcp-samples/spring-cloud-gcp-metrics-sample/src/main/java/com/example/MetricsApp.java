package com.example;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.jvm.JvmMemoryMetrics;
import io.micrometer.stackdriver.StackdriverMeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MetricsApp {

  @Autowired
  private JvmMemoryMetrics jvmMemoryMetrics;

  public static void main(String[] args) {
    SpringApplication.run(MetricsApp.class, args);
    System.out.println("I am here");
  }

  @Bean
  MeterRegistryCustomizer<StackdriverMeterRegistry> commonTags() {
    return (registry) -> {
      registry.config().commonTags("microservice", "galaxy");
      registry.config().commonTags("resourceType", "SOMETHINGWEIRD");
    };
  }

  @Bean
  public CommandLineRunner countMetric(MeterRegistry registry) {
    return (args) -> {
      System.out.println("HELLOOOO");
      registry.config().commonTags("application", "metrics sample");
      registry.counter("elena.test", "externalcontrib", "true");
      registry.gauge("elena.measure", 17);
    };

  }
}
