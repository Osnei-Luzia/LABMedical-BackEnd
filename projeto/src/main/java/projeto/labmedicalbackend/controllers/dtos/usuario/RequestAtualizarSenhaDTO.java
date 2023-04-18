package projeto.labmedicalbackend.controllers.dtos.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RequestAtualizarSenhaDTO {
    @NotBlank
    @Size(min = 8)
    private String senha;
}
