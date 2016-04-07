package com.projectbolek;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectBolekApplication {

	private static final Logger log = LoggerFactory.getLogger(ProjectBolekApplication.class);

	public static void main(String[] args) {
		log.info("Starting application");
		SpringApplication.run(ProjectBolekApplication.class, args);
	}
}
