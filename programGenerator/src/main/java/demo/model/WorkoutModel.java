package demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class WorkoutModel implements Serializable {

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
}
