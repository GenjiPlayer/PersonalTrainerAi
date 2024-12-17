package org.example.datarefactor.client;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RefactorClient {
    private final RestTemplate restTemplate;
    public RefactorClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}
