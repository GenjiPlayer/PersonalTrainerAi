package com.example.microserviceexam.repo;

import com.example.microserviceexam.model.userInput;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface reactRepo extends ReactiveCrudRepository<userInput, Long> {

}
