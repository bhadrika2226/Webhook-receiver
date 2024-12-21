package org.example.webhookreceiver.controller;

import org.example.webhookreceiver.model.LogPayload;
import org.example.webhookreceiver.service.BatchProcessor;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class WebhookController {
    private  static final Logger logger = LoggerFactory.getLogger(WebhookController.class);
    private  final BatchProcessor batchProcessor;

    public WebhookController(BatchProcessor batchProcessor){
        this.batchProcessor=batchProcessor;
    }

    @GetMapping("/healthz")
    public ResponseEntity<String> healthCheck(){
        logger.info("Health check endpoint accessed!!");
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/log")
    public ResponseEntity<String> logData(@RequestBody LogPayload payload){
        logger.info("Received payload: {}" , payload);
        batchProcessor.addPayload(payload);
        return ResponseEntity.ok("Payload Received!!");
    }

}
