package org.example.datarefactor.controller;

import org.example.datarefactor.model.RefactorModel;
import org.example.datarefactor.service.RefactorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/refactor")
@CrossOrigin(origins = "http://localhost:3000")
public class RefactorController {

    @Autowired
    private RefactorService refactorService;

    @GetMapping("/all")
    public ResponseEntity<List<RefactorModel>> getAllData() {
        List<RefactorModel> allData = refactorService.getAllData();
        return ResponseEntity.ok(allData);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RefactorModel> getDataById(@PathVariable Long id) {
        RefactorModel data = refactorService.getDataById(id);
        return ResponseEntity.ok(data);
    }

    @GetMapping("/enriched")
    public ResponseEntity<List<Object>> getEnrichedData() {
        List<RefactorModel> allData = refactorService.getAllData();

        List<Object> enrichedData = allData.stream()
                .map(data -> {
                    String parameter = data.getGymProficiency();
                    Object exerApiData = refactorService.getApiData(parameter);

                    return new Object() {
                        public RefactorModel refactorData = data;
                        public Object apiData = exerApiData;
                    };
                })
                .toList();

        return ResponseEntity.ok(enrichedData);
    }

}
