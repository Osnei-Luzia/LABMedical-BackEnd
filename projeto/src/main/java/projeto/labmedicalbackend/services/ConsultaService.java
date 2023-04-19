package projeto.labmedicalbackend.services;

import org.springframework.stereotype.Service;
import projeto.labmedicalbackend.controllers.dtos.consulta.RequestAtualizarConsultaDTO;
import projeto.labmedicalbackend.controllers.dtos.consulta.RequestCriarConsultaDTO;
import projeto.labmedicalbackend.controllers.dtos.consulta.ResponseBuscarConsultaDTO;
import projeto.labmedicalbackend.services.mappers.ConsultaMapper;
import projeto.labmedicalbackend.models.Consulta;
import projeto.labmedicalbackend.repositories.ConsultaRepository;

@Service
public class ConsultaService {
    private final ConsultaRepository repository;
    private final ConsultaMapper mapper;

    public ConsultaService(ConsultaRepository repository, ConsultaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Consulta salvarConsulta(RequestCriarConsultaDTO request){
        return repository.save(mapper.map(request));
    }

    public Consulta alterarConsulta(RequestAtualizarConsultaDTO request, Long idConsulta){
        Consulta consulta = repository.findById(idConsulta).orElseThrow(() -> new IllegalArgumentException("Consulta não encontrada"));
        mapper.update(consulta, request);
        return repository.save(consulta);
    }

    public ResponseBuscarConsultaDTO buscarConsultaById(Long id){
        return mapper.map(repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Consulta não encontrada")));
    }

    public void deletarConsulta(Long id){
        Consulta consulta = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Consulta não encontrada"));
        repository.delete(consulta);
    }
}
