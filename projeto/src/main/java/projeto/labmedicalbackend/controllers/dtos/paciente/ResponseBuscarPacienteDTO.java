package projeto.labmedicalbackend.controllers.dtos.paciente;

import lombok.Data;
import projeto.labmedicalbackend.models.Endereco;
import projeto.labmedicalbackend.models.enums.EstadoCivil;

import java.util.List;

@Data
public class ResponseBuscarPacienteDTO {
    //pessoa
    private Long id;
    private String nomeCompleto;
    private String genero;
    private String dataNascimento;
    private String cpf;
    private String rg;
    private EstadoCivil estadoCivil;
    private String telefone;
    private String email;
    private String naturalidade;

    //paciente
    private List<String> listaAlergias;
    private List<String> listaCuidados;
    private String contatoEmergencia;
    private String convenio;
    private String numeroCarteira;
    private String validade;
    private Endereco endereco;
    private List<Long> exames;
}

