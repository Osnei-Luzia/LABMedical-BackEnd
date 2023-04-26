package projeto.labmedicalbackend.services;

import org.springframework.stereotype.Service;
import projeto.labmedicalbackend.controllers.dtos.paciente.RequestAtualizarPacienteDTO;
import projeto.labmedicalbackend.controllers.dtos.paciente.RequestCriarPacienteDTO;
import projeto.labmedicalbackend.controllers.dtos.paciente.ResponseBuscarPacienteDTO;
import projeto.labmedicalbackend.exceptions.CpfExistsException;
import projeto.labmedicalbackend.exceptions.DataExistsException;
import projeto.labmedicalbackend.services.mappers.PacienteMapper;
import projeto.labmedicalbackend.models.Paciente;
import projeto.labmedicalbackend.repositories.PacienteRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PacienteService {
    private final PacienteRepository repository;
    private final PacienteMapper mapper;
    private final EnderecoService enderecoService;

    public PacienteService(PacienteRepository repository, PacienteMapper mapper, EnderecoService enderecoService) {
        this.repository = repository;
        this.mapper = mapper;
        this.enderecoService = enderecoService;
    }

    public Paciente salvarPaciente(RequestCriarPacienteDTO request) {
        if (!enderecoService.existsEnderecoById(request.getEndereco().getId())) {
            throw new DataExistsException("Endereço não cadastrado");
        }
        if (!repository.existsPacienteByCpf(request.getCpf())) {
            Paciente paciente = mapper.map(request);
            paciente = repository.save(paciente);
            paciente.setEndereco(enderecoService.procurarEnderecoById(paciente.getEndereco().getId()));
            return paciente;
        } else {
            throw new CpfExistsException("CPF em uso por outro paciente");
        }
    }

    public Paciente alterarPaciente(RequestAtualizarPacienteDTO request, Long idPaciente) {
        Paciente paciente = repository.findById(idPaciente).orElseThrow(() -> new DataExistsException("Paciente não encontrado"));
        if (!enderecoService.existsEnderecoById(request.getEndereco().getId())) {
            throw new DataExistsException("Endereço não cadastrado");
        }
        mapper.update(paciente, request);
        paciente = repository.save(paciente);
        paciente.setEndereco(enderecoService.procurarEnderecoById(paciente.getEndereco().getId()));
        return paciente;
    }

    public ResponseBuscarPacienteDTO procurarPacientes(String nome) {
        return mapper.map(repository.findByNomeCompleto(nome).orElseThrow(() -> new DataExistsException("Paciente não encontrado")));
    }

    public List<ResponseBuscarPacienteDTO> procurarPacientes() {
        List<ResponseBuscarPacienteDTO> lista = repository.findAll().stream().map(
                                                paciente -> mapper.map(paciente))
                                                .collect(Collectors.toList());
        if(lista.size()<1){
            throw new DataExistsException("Não há pacientes cadastrados");
        }
        return lista;
    }

    public ResponseBuscarPacienteDTO procurarPacienteById(Long id) {
        return mapper.map(repository.findById(id).orElseThrow(() -> new DataExistsException("Paciente não encontrado")));
    }

    public void deletarPaciente(Long id) {
        Paciente paciente = repository.findById(id).orElseThrow(() -> new DataExistsException("Paciente não encontrado"));
        repository.delete(paciente);
    }

    public boolean existsPacienteById(Long id){
        return repository.existsById(id);
    }
}

