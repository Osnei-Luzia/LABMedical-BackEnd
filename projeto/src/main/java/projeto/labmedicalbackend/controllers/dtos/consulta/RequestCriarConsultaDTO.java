package projeto.labmedicalbackend.controllers.dtos.consulta;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import projeto.labmedicalbackend.models.Paciente;
import projeto.labmedicalbackend.models.Usuario;

import java.util.Date;
@Data
public class RequestCriarConsultaDTO {
    @NotBlank
    private String motivo;
    @NotNull
    private Date dataHora;
    //fazer pelo timestamp da inserção
    //validar data

    @NotNull
    private String descricao;
    @NotNull
    private String medicacao;
    @NotNull
    private String dosagens;
    @NotNull
    private Paciente paciente_id;
    @NotNull
    private Usuario usuario_id;
}
