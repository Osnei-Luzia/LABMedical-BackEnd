package projeto.labmedicalbackend.controllers.dtos.exame;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import projeto.labmedicalbackend.models.Paciente;
import projeto.labmedicalbackend.models.Usuario;

import java.util.Date;

@Data
public class RequestCriarExameDTO {
    @NotBlank
    private String nome;
    @NotNull
    private Date dataHora;
    //fazer pelo timestamp da inserção
    //validar data

    @NotBlank
    private String tipo;
    @NotBlank
    private String laboratorio;
    private String arquivo;
    //conferir arquivo
    @NotBlank
    private String resultado;
    private Paciente paciente_id;
    private Usuario usuario_id;
}
