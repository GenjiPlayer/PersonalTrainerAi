package org.example.datarefactor.repository;

import org.example.datarefactor.model.RefactorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefactorRepository extends JpaRepository<RefactorModel, Long> {

}
