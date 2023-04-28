package projeto.labmedicalbackend.controllers.dtos.paciente;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import projeto.labmedicalbackend.models.Endereco;
import projeto.labmedicalbackend.models.enums.EstadoCivil;
import projeto.labmedicalbackend.validators.DateConstraint;

import java.util.List;

@Data
public class RequestAtualizarPacienteDTO {
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
