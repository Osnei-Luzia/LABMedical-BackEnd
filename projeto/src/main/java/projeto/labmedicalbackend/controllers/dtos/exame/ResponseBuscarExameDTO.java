package projeto.labmedicalbackend.controllers.dtos.exame;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import projeto.labmedicalbackend.models.Paciente;
import projeto.labmedicalbackend.models.Usuario;

import java.util.Date;

@Data
public class ResponseBuscarExameDTO {
    private Long id;
    private String nome;
    private Date dataHora;
    private String tipo;
    private String laboratorio;
    private String arquivo;
    private String resultado;
    private Long paciente_id;
    private Long usuario_id;

    public void setPaciente_id(Paciente paciente) {
        this.paciente_id = paciente.getId();
    }

    public void setUsuario_id(Usuario usuario) {
        this.usuario_id = usuario.getId();
    }
}
