package com.example.SubmersibleProbe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.availability.LivenessStateHealthIndicator;
import org.springframework.boot.actuate.availability.ReadinessStateHealthIndicator;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SubmersibleProbeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubmersibleProbeApplication.class, args);
	}

}
