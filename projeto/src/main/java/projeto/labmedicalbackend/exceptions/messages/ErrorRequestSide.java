package projeto.labmedicalbackend.exceptions.messages;

import lombok.Data;
import org.springframework.validation.FieldError;

@Data
public class ErrorRequestSide {
    private final String campo;
    private final String mensagem;

    public ErrorRequestSide(FieldError erro) {
        this.campo = erro.getField();
        this.mensagem = erro.getDefaultMessage();
    }
}
