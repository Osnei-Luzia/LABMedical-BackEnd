package projeto.labmedicalbackend.controllers.dtos.paciente;

import lombok.Data;
import projeto.labmedicalbackend.models.Endereco;
import projeto.labmedicalbackend.models.enums.EstadoCivil;

import java.util.Date;
import java.util.List;

@Data
public class ResponseBuscarPacienteDTO {
    //pessoa
    private String nomeCompleto;
    private String genero;
    private String dataNascimento;
    private String cpf;
    private String rg;
    private EstadoCivil estadoCivil;
    /*
     * 1- Solteiro
     * 2- Casado
     * 3- Separado
     * 4- Divorciado
     * 5- Viúvo
     * */
    private String telefone;
    private String email;
    private String naturalidade;

    //paciente

    private List<String> listaAlergias;
    private List<String> listaCuidados;
    private String contatoEmergencia;
    private String convenio;
    private String numeroCarteira;

    private Date validade;

    private Endereco endereco;
    private Integer exames;
    private Integer consultas;
}

