package projeto.labmedicalbackend.controllers.dtos.usuario;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.Date;

@Data
public class RequestCriarUsuarioDTO {
    //pessoa
    private String nomeCompleto;
    private String genero;

    private Date dataNascimento;
    //validar data
    @CPF
    private String cpf;
    private String rg;
    @Min(value = 1)
    @Max(value = 5)
    @NotNull
    private Integer estadoCivil;
    /*
     * Solteiro
     * Casado
     * Separado
     * Divorciado
     * Viúvo
     * */
    private String telefone;
    @Email
    private String email;

    private String naturalidade;

    //usuario
    @NotBlank
    private String crm;
    @Min(value = 1)
    @Max(value = 8)
    @NotNull
    private Integer especializacao;
    @Size(min = 8)
    private String senha;
}
