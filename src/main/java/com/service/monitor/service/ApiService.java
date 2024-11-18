package com.service.monitor.service;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.service.monitor.model.Response;

import reactor.core.publisher.Mono;

@Service

public class ApiService {
   private final WebClient webClient;

    public ApiService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://apip.sales.agl-allianz.com").build();
    }

    // public Mono<String> sendPostRequest(String rawData) {
    //     return this.webClient.get()
    //             .uri("/getQuiz")
    //             .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
    //             //.bodyValue(rawData)  // Raw JSON data here
    //             .retrieve()
    //             .bodyToMono(String.class);
    // }

    public Mono<Response> sendGetRequest(String endpoint) {
        return this.webClient.get()
                .uri(endpoint)  // Pass the specific endpoint
                .retrieve()  // Retrieve the response
                .bodyToMono(Response.class);
    }
}
