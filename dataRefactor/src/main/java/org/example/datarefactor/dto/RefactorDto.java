package org.example.datarefactor.dto;
import lombok.*;
import org.example.datarefactor.model.RefactorModel;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RefactorDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private RefactorModel refactorData;
    private Object apiData;
}
