package org.example.datarefactor.service;

import org.example.datarefactor.model.RefactorModel;
import org.example.datarefactor.repository.RefactorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
public class RefactorService {

    @Autowired
    private RefactorRepository refactorRepository;

    @Autowired
    private RestTemplate restTemplate;

    public List<RefactorModel> getAllData() {
        return refactorRepository.findAll();
    }

    public RefactorModel getDataById(Long id) {
        return refactorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data not found... id: " + id));
    }

    public Object getApiData(String apiName) {
        String url = "https://api.api-ninjas.com/v1/exercises?Name" + apiName;

        try {
            return restTemplate.getForObject(url, Object.class);
        }catch (RestClientException e) {
            throw new RuntimeException("Failed to get data from API: " + apiName, e);
        }
    }
}
