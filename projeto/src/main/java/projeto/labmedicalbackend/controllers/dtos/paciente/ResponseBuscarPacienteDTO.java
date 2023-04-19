package projeto.labmedicalbackend.controllers.dtos.paciente;

import lombok.Data;
import projeto.labmedicalbackend.models.Endereco;

import java.util.Date;
import java.util.List;

@Data
public class ResponseBuscarPacienteDTO {
    //pessoa
    private String nomeCompleto;
    private String genero;
    private Date dataNascimento;
    //validar data
    private String cpf;
    private String rg;
    private Integer estadoCivil;
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

