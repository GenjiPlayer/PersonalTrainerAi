package org.example.datarefactor.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.example.datarefactor.dto.RefactorDto;
import org.example.datarefactor.model.RefactorModel;
import org.example.datarefactor.repository.RefactorRepository;
import org.example.datarefactor.service.RefactorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/refactor")
@CrossOrigin(origins = "*")
public class RefactorController {

    @Autowired
    private RefactorService refactorService;
    @Autowired
    private RefactorRepository refactorRepository;
    private final String ProgramGenerator = "http://localhost:8081/refactor/send-to-generator";

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
    @JsonIgnore
    @PostMapping("/enriched")
    public ResponseEntity<RefactorDto> getEnrichedData(@RequestBody RefactorModel refactorModel) {
        RefactorModel savedModel = refactorRepository.save(refactorModel);
        RefactorDto enrichedData = new RefactorDto(savedModel, ProgramGenerator);
        System.out.println("Saved and enriched model: " + savedModel);
        String send = refactorService.sendDataToGenerator(savedModel);
        System.out.println("Sent to svein :3" + send);
        return ResponseEntity.ok(enrichedData);
    }
}
