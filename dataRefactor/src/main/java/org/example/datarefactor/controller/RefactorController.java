package org.example.datarefactor.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.example.datarefactor.dto.RefactorDto;
import org.example.datarefactor.model.RefactorModel;
import org.example.datarefactor.rabbitMQ.eventDispatch;
import org.example.datarefactor.repository.RefactorRepository;
import org.example.datarefactor.service.RefactorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Ref;
import java.util.List;

@RestController
@RequestMapping("/refactor")
@CrossOrigin(origins = "*")
public class RefactorController {

    @Autowired
    private RefactorService refactorService;
    @Autowired
    private RefactorRepository refactorRepository;

    @Autowired
    private eventDispatch e;

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
    public ResponseEntity<RefactorModel> getEnrichedData(@RequestBody RefactorDto refactorDto) {
        RefactorModel refactorModel = new RefactorModel(
                refactorDto.getId(),
                refactorDto.getGymProficiency()
        );
        e.send(refactorDto);
        refactorService.sendDataToGenerator(refactorDto);
        refactorRepository.save(refactorModel);
        return ResponseEntity.ok(refactorModel);
    }
}
