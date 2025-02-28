package com.example.microserviceexam.client;

import com.example.microserviceexam.dto.userDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class inputClient implements inputClientImp {

    private final WebClient webClient;

    public inputClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8081").build();
    }

    @Override
    public Mono<Object> refactor(userDTO userdto) {
        return webClient.post()
                .uri("/refactor/enriched")
                .bodyValue(userdto)
                .retrieve()
                .bodyToMono(Object.class)
                .doOnSuccess(response -> System.out.println("efactor service succeeded: " + response))
                .doOnError(error -> System.out.println("Refactor service failed: " + error.getMessage()));
    }
}