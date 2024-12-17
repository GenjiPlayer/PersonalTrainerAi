package demo.repository;

import demo.model.WorkoutModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutRepository extends JpaRepository<WorkoutModel, Long> {
}
