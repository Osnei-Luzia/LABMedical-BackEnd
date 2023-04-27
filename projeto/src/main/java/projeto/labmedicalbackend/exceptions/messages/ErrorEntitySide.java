package projeto.labmedicalbackend.exceptions.messages;

import jakarta.validation.ConstraintViolation;
import lombok.Data;
import org.springframework.validation.FieldError;

import java.util.Iterator;

@Data
public class ErrorEntitySide {
    private final String campo;
    private final String mensagem;

    public ErrorEntitySide(ConstraintViolation erro) {
        this.campo = erro.getPropertyPath().toString();
        this.mensagem = erro.getMessage();
    }
}