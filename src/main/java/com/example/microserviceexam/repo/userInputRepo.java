package com.example.microserviceexam.repo;
import com.example.microserviceexam.model.userInput;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userInputRepo extends R2dbcRepository<userInput, Long> {

}
