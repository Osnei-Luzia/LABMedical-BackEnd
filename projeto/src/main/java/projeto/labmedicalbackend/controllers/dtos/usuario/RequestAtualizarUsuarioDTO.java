package projeto.labmedicalbackend.controllers.dtos.usuario;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;

import java.util.Date;

@Data
public class RequestAtualizarUsuarioDTO {
    //verificar cpf e rg

    //pessoa
    private String nomeCompleto;
    private String genero;
    private Date dataNascimento;
    //validar data
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
    //verificar senha
}
