package org.example.webhookreceiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAsync
public class WebhookReceiverApplication {

	private static final Logger logger = LoggerFactory.getLogger(WebhookReceiverApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(WebhookReceiverApplication.class, args);
		logger.info("Application started successfully.");
	}

}
