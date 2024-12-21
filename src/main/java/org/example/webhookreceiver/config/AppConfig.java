package org.example.webhookreceiver.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Value("${batch.size:10}")
    private int batchSize;

    @Value("${batch.interval:30}")
    private int batchInterval;

    @Value("${post.endpoint:http://example.com/endpoint}")
    private String postEndpoint;

    public int getBatchSize(){
        return batchSize;
    }

    public int getBatchInterval() {
        return batchInterval;
    }

    public String getPostEndpoint(){
        return postEndpoint;
    }
}
