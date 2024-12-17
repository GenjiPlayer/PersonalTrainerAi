package org.example.datarefactor.service;

import org.example.datarefactor.model.RefactorModel;
import org.example.datarefactor.repository.RefactorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class RefactorService {

    @Autowired
    private RefactorRepository refactorRepository;

    @Autowired
    private RestTemplate restTemplate;

    private final String ProgramGenerator = "http://localhost:8082/api/workout/generate";

    public String sendDataToGenerator(String gymProficency) {
        try {
            Map<String, String> requestBody = Map.of("gymProfficency", gymProficency);
            return restTemplate.postForObject(ProgramGenerator, requestBody, String.class);
        } catch (RestClientException e) {
            throw new RuntimeException("Failed to send data to generator", e);
        }
    }

    public List<RefactorModel> getAllData() {
        return refactorRepository.findAll();
    }

    public RefactorModel getDataById(Long id) {
        return refactorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data not found... id: " + id));
    }

}
