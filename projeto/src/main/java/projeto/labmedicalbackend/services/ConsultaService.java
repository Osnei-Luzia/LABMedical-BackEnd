package projeto.labmedicalbackend.services;

import org.springframework.stereotype.Service;
import projeto.labmedicalbackend.controllers.dtos.consulta.RequestAtualizarConsultaDTO;
import projeto.labmedicalbackend.controllers.dtos.consulta.RequestCriarConsultaDTO;
import projeto.labmedicalbackend.controllers.dtos.consulta.ResponseBuscarConsultaDTO;
import projeto.labmedicalbackend.exceptions.DataExistsException;
import projeto.labmedicalbackend.services.mappers.ConsultaMapper;
import projeto.labmedicalbackend.models.Consulta;
import projeto.labmedicalbackend.repositories.ConsultaRepository;

import java.util.Date;
import java.util.Objects;

@Service
public class ConsultaService {
    private final ConsultaRepository repository;
    private final ConsultaMapper mapper;

    private final PacienteService pacienteService;
    private final UsuarioService usuarioService;

    public ConsultaService(ConsultaRepository repository, ConsultaMapper mapper, PacienteService pacienteService, UsuarioService usuarioService) {
        this.repository = repository;
        this.mapper = mapper;
        this.pacienteService = pacienteService;
        this.usuarioService = usuarioService;
    }

    public ResponseBuscarConsultaDTO salvarConsulta(RequestCriarConsultaDTO request) {
        if (!pacienteService.existsPacienteById(request.getPaciente_id().getId())) {
            throw new DataExistsException("Paciente não cadastrado");
        }
        if (!usuarioService.existsUsuarioById(request.getUsuario_id().getId())) {
            throw new DataExistsException("Usuário não cadastrado");
        }
        request.setDataHora(new Date());//configurar timestamp?
        ResponseBuscarConsultaDTO response = mapper.map(repository.save(mapper.map(request)));
        return response;
    }

    public ResponseBuscarConsultaDTO alterarConsulta(RequestAtualizarConsultaDTO request, Long idConsulta) {
        Consulta consulta = repository.findById(idConsulta).orElseThrow(() -> new DataExistsException("Consulta não encontrada"));
        if (!Objects.isNull(request.getPaciente_id())) {
            if (!pacienteService.existsPacienteById(request.getPaciente_id().getId())) {
                throw new DataExistsException("Paciente não cadastrado");
            }
        } else {
            request.setPaciente_id(consulta.getPaciente_id());
        }
        if (!Objects.isNull(request.getUsuario_id())) {
            if (!usuarioService.existsUsuarioById(request.getUsuario_id().getId())) {
                throw new DataExistsException("Usuário não cadastrado");
            }
        } else {
            request.setUsuario_id(consulta.getUsuario_id());
        }
        mapper.update(consulta, request);
        ResponseBuscarConsultaDTO response = mapper.map(repository.save((consulta)));
        return response;
    }

    public ResponseBuscarConsultaDTO buscarConsultaById(Long id) {
        return mapper.map(repository.findById(id).orElseThrow(() -> new DataExistsException("Consulta não encontrada")));
    }

    public void deletarConsulta(Long id) {
        Consulta consulta = repository.findById(id).orElseThrow(() -> new DataExistsException("Consulta não encontrada"));
        repository.delete(consulta);
    }
}
