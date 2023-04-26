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
    private Date dataHora;
    @NotBlank
    private String tipo;
    @NotBlank
    private String laboratorio;
    private String arquivo;
    @NotBlank
    private String resultado;
    @NotNull
    private Paciente paciente_id;
    @NotNull
    private Usuario usuario_id;
}
