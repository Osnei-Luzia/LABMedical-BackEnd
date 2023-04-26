package projeto.labmedicalbackend.controllers.dtos.paciente;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;
import projeto.labmedicalbackend.models.Endereco;
import projeto.labmedicalbackend.models.enums.EstadoCivil;
import projeto.labmedicalbackend.validators.DateConstraint;
import projeto.labmedicalbackend.validators.EnumConstraint;

import java.util.Date;
import java.util.List;

@Data
public class RequestAtualizarPacienteDTO {
    private String nomeCompleto;
    private String genero;
    @Pattern(regexp = "^[0-9]{1,2}\\/[0-9]{1,2}\\/[0-9]{4}$", message = "use o formato dd/MM/aaaa")
    @DateConstraint
    private String dataNascimento;
    @EnumConstraint(targetClassType = EstadoCivil.class, message = "estado civil inválido")
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

    //paciente
    private List<String> listaAlergias;
    private List<String> listaCuidados;
    private String contatoEmergencia;
    private String convenio;
    private String numeroCarteira;
    @Pattern(regexp = "^[0-9]{1,2}\\/[0-9]{1,2}\\/[0-9]{4}$", message = "use o formato dd/MM/aaaa")
    @DateConstraint
    private String validade;
    private Endereco endereco;

}
