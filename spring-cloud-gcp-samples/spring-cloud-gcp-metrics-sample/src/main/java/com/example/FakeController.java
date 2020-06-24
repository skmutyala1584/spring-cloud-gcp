package com.example;

import io.micrometer.core.annotation.Timed;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FakeController {
  @Timed
  @GetMapping("blah")
  public String getBlah() {
    return "I told you blah";
  }
}
