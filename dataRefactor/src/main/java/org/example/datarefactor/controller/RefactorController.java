package org.example.datarefactor.controller;

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
@CrossOrigin(origins = "http://localhost:3000")
public class RefactorController {

    private final List<RefactorModel> temporaryStorage = new ArrayList<>();
    @Autowired
    private RefactorService refactorService;
    @Autowired
    private RefactorRepository refactorRepository;
    private final String ProgramGenerator = "http://localhost:8090/refactor/send-to-generator";

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

    @PostMapping("/enriched")
    public ResponseEntity<RefactorDto> getEnrichedData(@RequestBody RefactorModel refactorModel) {
        RefactorModel savedModel = refactorRepository.save(refactorModel);
        RefactorDto enrichedData = new RefactorDto(savedModel, ProgramGenerator);
        System.out.println("Saved and enriched model: " + savedModel);
        return ResponseEntity.ok(enrichedData);
    }

        @PostMapping("/send-to-generator")
    public ResponseEntity<String> sendToGenerator(@RequestBody RefactorModel refactorModel) {
        String gymProficency = refactorModel.getGymProficiency();
        String response = refactorService.sendDataToGenerator(gymProficency);
        System.out.println("lololol" + gymProficency);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<RefactorModel>> getAllRefactoredData() {
        return ResponseEntity.ok(temporaryStorage);
    }
}
