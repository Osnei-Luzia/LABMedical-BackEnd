package projeto.labmedicalbackend.services;

import org.springframework.stereotype.Service;
import projeto.labmedicalbackend.controllers.dtos.exame.RequestAtualizarExameDTO;
import projeto.labmedicalbackend.controllers.dtos.exame.RequestCriarExameDTO;
import projeto.labmedicalbackend.controllers.dtos.exame.ResponseBuscarExameDTO;
import projeto.labmedicalbackend.exceptions.DataExistsException;
import projeto.labmedicalbackend.models.Exame;
import projeto.labmedicalbackend.repositories.ExameRepository;
import projeto.labmedicalbackend.services.mappers.ExameMapper;

import java.util.Date;
import java.util.Objects;

@Service
public class ExameService {
    private final ExameRepository repository;
    private final ExameMapper mapper;

    private final PacienteService pacienteService;
    private final UsuarioService usuarioService;

    public ExameService(ExameRepository repository, ExameMapper mapper, PacienteService pacienteService, UsuarioService usuarioService) {
        this.repository = repository;
        this.mapper = mapper;
        this.pacienteService = pacienteService;
        this.usuarioService = usuarioService;
    }

    public ResponseBuscarExameDTO salvarExame(RequestCriarExameDTO request){
        if (!Objects.isNull(request.getPaciente_id().getId())) {
            if (!pacienteService.existsPacienteById(request.getPaciente_id().getId())) {
                throw new DataExistsException("Paciente não cadastrado");
            }
        } else {
            throw new DataExistsException("Paciente não cadastrado");
        }
        if (!Objects.isNull(request.getUsuario_id().getId())) {
            if (!usuarioService.existsUsuarioById(request.getUsuario_id().getId())) {
                throw new DataExistsException("Usuário não cadastrado");
            }
        } else {
            throw new DataExistsException("Usuário não cadastrado");
        }
        request.setDataHora(new Date());//configurar timestamp?
        ResponseBuscarExameDTO response = mapper.map(repository.save(mapper.map(request)));
        return response;
    }

    public ResponseBuscarExameDTO alterarExame(RequestAtualizarExameDTO request, Long id){
        Exame exame = repository.findById(id).orElseThrow(() -> new DataExistsException("Exame não encontrado"));
        //checar id dentro de paciente e usuario
        if (!Objects.isNull(request.getPaciente_id())) {
            if (!pacienteService.existsPacienteById(request.getPaciente_id().getId())) {
                throw new DataExistsException("Paciente não cadastrado");
            }
        } else {
            request.setPaciente_id(exame.getPaciente_id());
        }
        if (!Objects.isNull(request.getUsuario_id())) {
            if (!usuarioService.existsUsuarioById(request.getUsuario_id().getId())) {
                throw new DataExistsException("Usuário não cadastrado");
            }
        } else {
            request.setUsuario_id(exame.getUsuario_id());
        }
        mapper.update(exame, request);
        ResponseBuscarExameDTO response = mapper.map(repository.save((exame)));
        return response;
    }

    public ResponseBuscarExameDTO procurarExameById(Long id){
        return mapper.map(repository.findById(id).orElseThrow(() -> new DataExistsException("Exame não encontrado")));
    }

    public void deletarExame(Long id){
        Exame exame = repository.findById(id).orElseThrow(() -> new DataExistsException("Exame não encontrado"));
        repository.delete(exame);
    }

    public Long contarExames(){
        return repository.count();
    }
}
