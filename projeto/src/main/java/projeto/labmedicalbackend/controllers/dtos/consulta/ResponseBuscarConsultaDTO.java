package projeto.labmedicalbackend.controllers.dtos.consulta;

import lombok.Data;
import projeto.labmedicalbackend.models.Paciente;
import projeto.labmedicalbackend.models.Usuario;

import java.util.Date;
@Data
public class ResponseBuscarConsultaDTO {
    private Long id;
    private String motivo;
    private Date dataHora;
    private String descricao;
    private String medicacao;
    private String dosagens;
    private Long paciente_id;
    private Long usuario_id;

    public void setPaciente_id(Paciente paciente) {
        this.paciente_id = paciente.getId();
    }

    public void setUsuario_id(Usuario usuario) {
        this.usuario_id = usuario.getId();
    }
}
