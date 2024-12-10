package org.example.datarefactor.service;

import org.example.datarefactor.model.RefactorModel;
import org.example.datarefactor.repository.RefactorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RefactorService {

    @Autowired
    private RefactorRepository refactorRepository;

    public List<RefactorModel> getAllData() {
        return refactorRepository.findAll();
    }

    public RefactorModel getDataById(Long id) {
        return refactorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data not found... id: " + id));
    }
}
