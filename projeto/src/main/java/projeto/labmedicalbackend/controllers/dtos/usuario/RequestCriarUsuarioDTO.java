package projeto.labmedicalbackend.controllers.dtos.usuario;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;
import jakarta.validation.constraints.*;
import lombok.Data;
import projeto.labmedicalbackend.models.enums.Especializacao;
import projeto.labmedicalbackend.models.enums.EstadoCivil;
import projeto.labmedicalbackend.validators.DateConstraint;
import projeto.labmedicalbackend.validators.EnumConstraint;


@Data
public class RequestCriarUsuarioDTO {
    //pessoa
    @NotBlank
    private String nomeCompleto;
    @NotBlank
    private String genero;
    @NotBlank
    @Pattern(regexp = "^[0-9]{1,2}\\/[0-9]{1,2}\\/[0-9]{4}$", message = "use o formato dd/MM/aaaa")
    @DateConstraint
    private String dataNascimento;
    @CPF
    @NotBlank
    private String cpf;
    @NotBlank
    private String rg;
    @NotNull
    @EnumConstraint(targetClassType = EstadoCivil.class, message = "estado civil inválido")
    private EstadoCivil estadoCivil;
    /*
     * 0- Solteiro
     * 1- Casado
     * 2- Separado
     * 3- Divorciado
     * 4- Viúvo
     */
    @NotBlank
    private String telefone;
    @Email(message = "deve ser um endereço de e-mail válido. exemplo@exemplo")
    @NotBlank
    private String email;
    @NotBlank
    private String naturalidade;

    //usuario
    @NotBlank
    private String crm;
    @NotNull
    @EnumConstraint(targetClassType = Especializacao.class, message = "especialização inválida")
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
    @Size(min = 8, message = "tamanho deve ser de no mínimo 8 caractéres")
    @NotBlank
    @Pattern(regexp = "^[A-Za-z0-9]*$",message = "apenas caractéres alfanuméricos")
    private String senha;
}
