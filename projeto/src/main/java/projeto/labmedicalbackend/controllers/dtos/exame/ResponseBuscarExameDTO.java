package projeto.labmedicalbackend.controllers.dtos.exame;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import projeto.labmedicalbackend.models.Paciente;
import projeto.labmedicalbackend.models.Usuario;

import java.util.Date;

@Data
public class ResponseBuscarExameDTO {
    private String nome;
    private Date dataHora;
    private String tipo;
    private String laboratorio;
    private String arquivo;
    private String resultado;
    private Paciente paciente_id;
    private Usuario usuario_id;
}
