package projeto.labmedicalbackend.controllers.dtos.endereco;

import lombok.Data;

@Data
public class ResponseBuscarEnderecoDTO {
    private String cep;
    private String cidade;
    private String estado;
    private String logradouro;
    private Integer numero;
    private String complemento;
    private String bairro;
    private String pontoReferencia;
}
