package projeto.labmedicalbackend.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataExistsException extends IllegalArgumentException{
    private String message;
}
