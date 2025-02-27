package com.example.microserviceexam.repo;

import com.example.microserviceexam.model.userInput;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userInputRepo extends JpaRepository<userInput, Long> {

}