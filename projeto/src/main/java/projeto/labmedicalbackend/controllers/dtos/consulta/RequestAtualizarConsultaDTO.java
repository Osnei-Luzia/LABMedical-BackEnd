package projeto.labmedicalbackend.controllers.dtos.consulta;

import lombok.Data;
import projeto.labmedicalbackend.models.Paciente;
import projeto.labmedicalbackend.models.Usuario;

@Data
public class RequestAtualizarConsultaDTO {
    private String motivo;
    private String descricao;
    private String medicacao;
    private String dosagens;
    private Paciente paciente_id;
    private Usuario usuario_id;
}
