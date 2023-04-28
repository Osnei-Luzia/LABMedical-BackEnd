package projeto.labmedicalbackend.controllers.dtos.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RequestAtualizarSenhaDTO {
    @Size(min = 8, message = "tamanho deve ser de no mínimo 8 caractéres")
    @NotBlank
    @Pattern(regexp = "^[A-Za-z0-9]*$", message = "apenas caractéres alfanuméricos")
    private String senha;
}
