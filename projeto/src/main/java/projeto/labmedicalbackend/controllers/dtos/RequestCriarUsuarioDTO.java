package projeto.labmedicalbackend.controllers.dtos;

import jakarta.persistence.Column;
import lombok.Data;

import java.util.Date;
@Data
public class RequestCriarUsuarioDTO {
    //pessoa
    private String nomeCompleto;
    private String genero;
    private Date dataNascimento;
    //verificar data
    //@CPF
    private String cpf;
    //123.456.789-10
    private String rg;
    //checar como fazer o length de number
    private Number estadoCivil;
    /*
     * Solteiro
     * Casado
     * Separado
     * Divorciado
     * Viúvo
     * */
    //verificar tipo String ou number
    private String telefone;
    private String email;

    private String naturalidade;

    //usuario
    private String crm;
    //checar como fazer o length de number
    private Number especializacao;
    private String senha;
}
