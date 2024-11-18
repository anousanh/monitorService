package com.service.monitor.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class MonitorService {
    @Value("${services.urls:}")
    private String[] serviceUrls;

    public Map<String, String> checkAllServices() {
        Map<String, String> healthStatus = new HashMap<>();
        WebClient webClient = WebClient.create();

        for (String url : serviceUrls) {
            try {
                String response = webClient.get()
                        .uri(url)
                        .retrieve()
                        .bodyToMono(String.class)
                        .block();
                healthStatus.put(url, "UP");
            } catch (Exception e) {
                healthStatus.put(url, "DOWN");
            }
        }
        return healthStatus;
    }
}
