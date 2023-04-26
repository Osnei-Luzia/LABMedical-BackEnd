package projeto.labmedicalbackend.controllers.dtos.consulta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import projeto.labmedicalbackend.models.Paciente;
import projeto.labmedicalbackend.models.Usuario;

import java.util.Date;

@Data
public class RequestAtualizarConsultaDTO {
    private String motivo;
    private String descricao;
    private String medicacao;
    private String dosagens;
    private Paciente paciente_id;
    private Usuario usuario_id;
}
