package projeto.labmedicalbackend.services;

import org.springframework.stereotype.Service;
import projeto.labmedicalbackend.controllers.dtos.ListagemDTO;

@Service
public class EstatisticasService {
    private final PacienteService pacienteService;
    private final ConsultaService consultaService;
    private final ExameService exameService;

    public EstatisticasService(PacienteService pacienteService, ConsultaService consultaService, ExameService exameService) {
        this.pacienteService = pacienteService;
        this.consultaService = consultaService;
        this.exameService = exameService;
    }

    public ListagemDTO procurarEstatisticas() {
        ListagemDTO listagem = new ListagemDTO();
        listagem.setPacientes(pacienteService.contarPacientes());
        listagem.setConsultas(consultaService.contarConsultas());
        listagem.setExames(exameService.contarExames());
        return listagem;
    }
}
