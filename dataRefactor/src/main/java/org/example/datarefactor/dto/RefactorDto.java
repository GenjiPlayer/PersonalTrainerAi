package org.example.datarefactor.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.datarefactor.model.RefactorModel;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
public class RefactorDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private RefactorModel refactorData;
    private Object apiData;

    // Explicitly define the constructor
    public RefactorDto(RefactorModel refactorData, Object apiData) {
        this.refactorData = refactorData;
        this.apiData = apiData;
    }
}
