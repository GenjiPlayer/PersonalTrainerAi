package com.example.microserviceexam.repo;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.microserviceexam.model.userInput;
@Repository
public interface userInputRepo extends JpaRepository<userInput, Long>{

}