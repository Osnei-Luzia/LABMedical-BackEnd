package projeto.labmedicalbackend.services;

import org.springframework.stereotype.Service;
import projeto.labmedicalbackend.controllers.dtos.consulta.RequestAtualizarConsultaDTO;
import projeto.labmedicalbackend.controllers.dtos.exame.RequestAtualizarExameDTO;
import projeto.labmedicalbackend.controllers.dtos.exame.RequestCriarExameDTO;
import projeto.labmedicalbackend.controllers.dtos.exame.ResponseBuscarExameDTO;
import projeto.labmedicalbackend.models.Consulta;
import projeto.labmedicalbackend.models.Exame;
import projeto.labmedicalbackend.repositories.ExameRepository;
import projeto.labmedicalbackend.services.mappers.ExameMapper;

@Service
public class ExameService {
    private final ExameRepository repository;
    private final ExameMapper mapper;

    public ExameService(ExameRepository repository, ExameMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Exame salvarExame(RequestCriarExameDTO request){
        return repository.save(mapper.map(request));
    }

    public Exame alterarExame(RequestAtualizarExameDTO request, Long id){
        Exame exame = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Exame não encontrado"));
        mapper.update(exame, request);
        return repository.save(exame);
    }

    public ResponseBuscarExameDTO procurarExameById(Long id){
        return mapper.map(repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Exame não encontrado")));
    }

    public void deletarExame(Long id){
        Exame exame = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Exame não encontrada"));
        repository.delete(exame);
    }
}
