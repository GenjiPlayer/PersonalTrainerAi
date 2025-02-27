package org.example.datarefactor.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.example.datarefactor.model.RefactorModel;
import org.example.datarefactor.repository.RefactorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RefactorService {

    @Autowired
    private RefactorRepository refactorRepository;

    @Autowired
    private RestTemplate restTemplate;

    private final String ProgramGenerator = "http://localhost:8081/api/workout/generate";

    @JsonIgnore
    public String sendDataToGenerator(RefactorModel refactorDto) {
        try {
            String res = restTemplate.postForObject(ProgramGenerator, refactorDto, String.class);
            System.out.println("YAHOO!" + res);
            return res;
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
