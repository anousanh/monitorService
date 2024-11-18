package com.service.monitor.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.monitor.model.Response;
import com.service.monitor.service.ApiService;
import com.service.monitor.service.MonitorService;

import reactor.core.publisher.Mono;

@RestController
public class Monitor {
    @Autowired
    private MonitorService monitorService;

    @Autowired
    private ApiService apiService;

    @GetMapping("/check")
    public Map<String, String> getHealthStatus() {
        return monitorService.checkAllServices();
    }

    //@GetMapping("/test")
    //public Mono<String> testPost() {
    //    String json = "{\"username\":\"anousan.n\",\"password\":\"123456\",\"ad\":false}";  // Replace with your raw JSON data
    //    return apiService.sendPostRequest(json);
    //}
        @GetMapping("/test")
        public Mono<Response> testGet() {
        String endpoint = "/api/getQuiz";  // Example API endpoint
        return apiService.sendGetRequest(endpoint);
    }
}
