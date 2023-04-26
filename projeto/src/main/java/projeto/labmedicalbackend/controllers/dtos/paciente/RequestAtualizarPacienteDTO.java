package projeto.labmedicalbackend.controllers.dtos.paciente;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;
import projeto.labmedicalbackend.models.Endereco;
import projeto.labmedicalbackend.models.enums.EstadoCivil;

import java.util.Date;
import java.util.List;

@Data
public class RequestAtualizarPacienteDTO {
    //pessoa
    private String nomeCompleto;
    private String genero;

    @NotBlank
    @Pattern(regexp = "^[0-9]{1,2}\\/[0-9]{1,2}\\/[0-9]{4}$")
    private String dataNascimento;
    //validar data
    @CPF
    private String cpf;
    private String rg;
    @NotNull
    private EstadoCivil estadoCivil;
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
    //paciente
    @ElementCollection
    private List<String> listaAlergias;
    @ElementCollection
    private List<String> listaCuidados;
    @Column(length = 64,nullable = false)
    @NotBlank
    private String contatoEmergencia;
    private String convenio;
    private String numeroCarteira;

    private Date validade;
    private Endereco endereco;

}
