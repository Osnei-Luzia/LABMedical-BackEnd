package projeto.labmedicalbackend.services;

import org.springframework.stereotype.Service;
import projeto.labmedicalbackend.controllers.dtos.paciente.RequestAtualizarPacienteDTO;
import projeto.labmedicalbackend.controllers.dtos.paciente.RequestCriarPacienteDTO;
import projeto.labmedicalbackend.controllers.dtos.paciente.ResponseBuscarPacienteDTO;
import projeto.labmedicalbackend.exceptions.CpfExistsException;
import projeto.labmedicalbackend.exceptions.DataExistsException;
import projeto.labmedicalbackend.exceptions.RegistroFilhoException;
import projeto.labmedicalbackend.repositories.ExameRepository;
import projeto.labmedicalbackend.services.mappers.PacienteMapper;
import projeto.labmedicalbackend.models.Paciente;
import projeto.labmedicalbackend.repositories.PacienteRepository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class PacienteService {
    private final PacienteRepository repository;
    private final PacienteMapper mapper;
    private final EnderecoService enderecoService;
    private final ExameRepository exameRepository;

    public PacienteService(PacienteRepository repository, PacienteMapper mapper, EnderecoService enderecoService, ExameRepository exameRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.enderecoService = enderecoService;
        this.exameRepository = exameRepository;
    }

    public ResponseBuscarPacienteDTO salvarPaciente(RequestCriarPacienteDTO request) {
        if (Objects.isNull(request.getEndereco().getId()) || !enderecoService.existsEnderecoById(request.getEndereco().getId())) {
            throw new DataExistsException("Endereço não cadastrado");
        }
        if (!repository.existsPacienteByCpf(request.getCpf())) {
            Paciente paciente = mapper.map(request);
            paciente = repository.save(paciente);
            paciente.setEndereco(enderecoService.procurarEnderecoById(paciente.getEndereco().getId()));
            ResponseBuscarPacienteDTO retorno = mapper.map(paciente);
            return retorno;
        } else {
            throw new CpfExistsException("CPF em uso por outro paciente");
        }
    }

    public Paciente alterarPaciente(RequestAtualizarPacienteDTO request, Long idPaciente) {
        Paciente paciente = repository.findById(idPaciente).orElseThrow(() -> new DataExistsException("Paciente não encontrado"));
        if (!Objects.isNull(request.getEndereco()) && !enderecoService.existsEnderecoById(request.getEndereco().getId())) {
            throw new DataExistsException("Endereço não cadastrado");
        }
        if (Objects.isNull(request.getEndereco())) {
            request.setEndereco(paciente.getEndereco());
        }
        if (Objects.isNull(request.getEstadoCivil())) {
            request.setEstadoCivil(paciente.getEstadoCivil());
        }
        mapper.update(paciente, request);
        paciente = repository.save(paciente);
        paciente.setEndereco(enderecoService.procurarEnderecoById(paciente.getEndereco().getId()));
        return paciente;
    }

    public ResponseBuscarPacienteDTO procurarPacientesByNome(String nome) {
        ResponseBuscarPacienteDTO paciente = mapper.map(repository.findByNomeCompleto(nome).orElseThrow(() -> new DataExistsException("Paciente não encontrado")));
        paciente.setExames(exameRepository.findAllByPaciente_id(paciente.getId()));
        return paciente;
    }

    public List<ResponseBuscarPacienteDTO> procurarPacientes() {
        List<ResponseBuscarPacienteDTO> lista = repository.findAll().stream().map(
                        paciente -> mapper.map(paciente))
                .collect(Collectors.toList());
        if (lista.size() < 1) {
            throw new DataExistsException("Não há pacientes cadastrados");
        }
        for (ResponseBuscarPacienteDTO paciente : lista) {
            paciente.setExames(exameRepository.findAllByPaciente_id(paciente.getId()));
        }
        return lista;
    }

    public ResponseBuscarPacienteDTO procurarPacienteById(Long id) {
        ResponseBuscarPacienteDTO paciente = mapper.map(repository.findById(id).orElseThrow(() -> new DataExistsException("Paciente não encontrado")));
        paciente.setExames(exameRepository.findAllByPaciente_id(paciente.getId()));
        return paciente;
    }

    public void deletarPaciente(Long id) {
        Paciente paciente = repository.findById(id).orElseThrow(() -> new DataExistsException("Paciente não encontrado"));
        try {
            repository.delete(paciente);
        } catch (RuntimeException e){
            throw new RegistroFilhoException("Paciente possui exames e ou consultas cadastradas");
        }
    }

    public boolean existsPacienteById(Long id) {
        return repository.existsById(id);
    }

    public Long contarPacientes() {
        return repository.count();
    }
}

