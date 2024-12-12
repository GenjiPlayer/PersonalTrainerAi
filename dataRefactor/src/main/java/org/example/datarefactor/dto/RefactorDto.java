package org.example.datarefactor.dto;
import lombok.*;
import org.example.datarefactor.model.RefactorModel;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RefactorDto {
    private RefactorModel refactorData;
    private Object apiData;
}
