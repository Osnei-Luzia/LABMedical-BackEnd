package projeto.labmedicalbackend.controllers.dtos.exame;

import lombok.Data;
import projeto.labmedicalbackend.models.Paciente;
import projeto.labmedicalbackend.models.Usuario;

@Data
public class RequestAtualizarExameDTO {
    private String nome;
    private String tipo;
    private String laboratorio;
    private String arquivo;
    private String resultado;
    private Paciente paciente_id;
    private Usuario usuario_id;
}
