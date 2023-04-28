package projeto.labmedicalbackend.controllers.dtos.usuario;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import projeto.labmedicalbackend.models.enums.Especializacao;
import projeto.labmedicalbackend.models.enums.EstadoCivil;
import projeto.labmedicalbackend.validators.DateConstraint;

@Data
public class RequestAtualizarUsuarioDTO {
    //pessoa
    private String nomeCompleto;
    private String genero;
    @Pattern(regexp = "^[0-9]{1,2}\\/[0-9]{1,2}\\/[0-9]{4}$", message = "use o formato dd/MM/aaaa")
    @DateConstraint
    private String dataNascimento;
    private EstadoCivil estadoCivil;
    private String telefone;
    @Email(message = "deve ser um endereço de e-mail válido. exemplo@exemplo")
    private String email;
    private String naturalidade;

    //usuario
    private String crm;
    private Especializacao especializacao;
}
