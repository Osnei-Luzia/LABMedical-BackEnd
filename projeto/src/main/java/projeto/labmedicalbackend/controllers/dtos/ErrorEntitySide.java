package projeto.labmedicalbackend.controllers.dtos;

import lombok.Data;
import org.springframework.validation.FieldError;

@Data
public class ErrorEntitySide {
    private final String campo;
    private final String mensagem;

    public ErrorEntitySide(FieldError erro) {
        this.campo = erro.getField();
        this.mensagem = erro.getDefaultMessage();
    }
}