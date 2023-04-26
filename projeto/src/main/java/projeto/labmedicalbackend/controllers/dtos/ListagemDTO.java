package projeto.labmedicalbackend.controllers.dtos;

import lombok.Data;

@Data
public class ListagemDTO {
    private Long pacientes;
    private Long consultas;
    private Long exames;
}
