package projeto.labmedicalbackend.controllers.dtos.usuario;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import projeto.labmedicalbackend.models.enums.Especializacao;
import projeto.labmedicalbackend.models.enums.EstadoCivil;
import projeto.labmedicalbackend.validators.DateConstraint;
import projeto.labmedicalbackend.validators.EnumConstraint;

@Data
public class RequestAtualizarUsuarioDTO {
    //pessoa
    private String nomeCompleto;
    private String genero;
    @Pattern(regexp = "^[0-9]{1,2}\\/[0-9]{1,2}\\/[0-9]{4}$", message = "use o formato dd/MM/aaaa")
    @DateConstraint
    private String dataNascimento;
    @EnumConstraint(targetClassType = EstadoCivil.class)
    private EstadoCivil estadoCivil;
    /*
     * 0- Solteiro
     * 1- Casado
     * 2- Separado
     * 3- Divorciado
     * 4- Viúvo
     */
    private String telefone;
    @Email(message = "deve ser um endereço de e-mail válido. exemplo@exemplo")
    private String email;
    private String naturalidade;

    //usuario
    private String crm;
    @EnumConstraint(targetClassType = Especializacao.class)
    private Especializacao especializacao;
    /*
     * 0- Clínico Geral
     * 1- Anestesista
     * 2- Dermatologia
     * 3- Ginecologia
     * 4- Neurologia
     * 5- Pediatria
     * 6- Psiquiatria
     * 7- Ortopedia
     */
}
