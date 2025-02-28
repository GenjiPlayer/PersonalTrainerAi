package demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WorkoutModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String gymProficiency;

    private Integer age;


    public String getGymProficiency() {
        return gymProficiency;
    }

    public Integer getAge() {
        return age;
    }

    public void setGymProficiency(String gymProficiency) {
        this.gymProficiency = gymProficiency;
    }

    public void setUserId(Long id) {
    }

    public void setWorkoutPlan(String workoutPlan) {
    }
}
