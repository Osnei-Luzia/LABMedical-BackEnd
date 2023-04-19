package projeto.labmedicalbackend.services;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import projeto.labmedicalbackend.controllers.dtos.paciente.RequestAtualizarPacienteDTO;
import projeto.labmedicalbackend.controllers.dtos.paciente.RequestCriarPacienteDTO;
import projeto.labmedicalbackend.controllers.dtos.paciente.ResponseBuscarPacienteDTO;
import projeto.labmedicalbackend.mappers.PacienteMapper;
import projeto.labmedicalbackend.models.Paciente;
import projeto.labmedicalbackend.repositories.PacienteRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PacienteService {
    private final PacienteRepository repository;
    private final PacienteMapper mapper;

    public PacienteService(PacienteRepository repository, PacienteMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Paciente salvarPaciente(RequestCriarPacienteDTO request) {
        //checar se endereco existe, usar outro repository?
        if (!repository.existsPacienteByCpf(request.getCpf())) {
            Paciente paciente = mapper.map(request);
            paciente.setExames(0);
            paciente.setConsultas(0);
            //default em banco = 0
            return repository.save(paciente);
        } else {
            throw new IllegalArgumentException("CPF já existe");//montar body com 409 conflict
        }
    }

    public Paciente alterarPaciente(RequestAtualizarPacienteDTO request, Long idPaciente) {
        Paciente paciente = repository.findById(idPaciente).orElseThrow(() -> new IllegalArgumentException("Paciente não encontrado"));
        mapper.update(paciente, request);
        return repository.save(paciente);
    }

    public ResponseBuscarPacienteDTO procurarPacientes(String nome){
        return mapper.map(repository.findByNomeCompleto(nome).orElseThrow(() -> new IllegalArgumentException("Paciente não encontrado")));
    }
    public List<ResponseBuscarPacienteDTO> procurarPacientes(){
        return repository.findAll().stream().map(
                paciente -> mapper.map(paciente))
                .collect(Collectors.toList());
    }

    public ResponseBuscarPacienteDTO procurarPacienteById(Long id){
        return mapper.map(repository.findById(id).orElseThrow(() ->new IllegalArgumentException("Paciente não encontrado")));
    }

    public void deletarPaciente(Long id){
        Paciente paciente = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Paciente não encontrado"));
        if(paciente.getExames()<1&&paciente.getConsultas()<1){
            repository.delete(paciente);
        }else{
            throw new IllegalArgumentException("Paciente possui exames ou consultas listados");//montar body com 409 conflict
        }
    }
}

