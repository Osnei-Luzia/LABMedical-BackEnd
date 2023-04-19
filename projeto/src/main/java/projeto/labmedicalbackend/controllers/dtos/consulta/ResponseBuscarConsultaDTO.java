package projeto.labmedicalbackend.controllers.dtos.consulta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import projeto.labmedicalbackend.models.Paciente;
import projeto.labmedicalbackend.models.Usuario;

import java.util.Date;
@Data
public class ResponseBuscarConsultaDTO {
    private String motivo;
    private Date dataHora;
    //fazer pelo timestamp da inserção
    //validar data
    private String descricao;
    private String medicacao;
    private String dosagens;
    private Paciente paciente_id;
    private Usuario usuario_id;
}
