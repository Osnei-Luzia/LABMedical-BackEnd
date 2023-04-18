package projeto.labmedicalbackend.controllers.dtos.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EnderecoBuscarDTO {
    private String cep;
    private String cidade;
    private String estado;
    private String logradouro;
    private Integer numero;
    private String complemento;
    private String bairro;
    private String pontoReferencia;
}
