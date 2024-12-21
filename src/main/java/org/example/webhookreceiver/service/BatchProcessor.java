package org.example.webhookreceiver.service;

import org.example.webhookreceiver.config.AppConfig;
import org.example.webhookreceiver.model.LogPayload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class BatchProcessor {
    private static final Logger logger= LoggerFactory.getLogger(BatchProcessor.class);
    private final List<LogPayload> payloads = new ArrayList<>();
    private final AppConfig config;
    private final RestTemplate restTemplate=new RestTemplate();

    public BatchProcessor(AppConfig config) {
        this.config = config;
    }

    public synchronized void addPayload(LogPayload payload){
        payloads.add(payload);
        if(payloads.size() >= config.getBatchSize()){
            sendBatch();
        }
    }

    @Scheduled(fixedRateString = "${batch.interval:3000}")
    public synchronized void processBatch(){
        if(!payloads.isEmpty()){
            sendBatch();
        }
    }

    private void sendBatch(){
        try {
            logger.info("SEnding batch of size:{}", payloads.size());
            restTemplate.postForEntity(config.getPostEndpoint(), new ArrayList<>(payloads),String.class);
            payloads.clear();
        }catch (Exception e){
            logger.error("Error sending Batch: {}",e.getMessage());
        }

    }

}
