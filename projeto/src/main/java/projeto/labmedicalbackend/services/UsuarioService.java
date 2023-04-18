package projeto.labmedicalbackend.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import projeto.labmedicalbackend.controllers.dtos.usuario.RequestAtualizarSenhaDTO;
import projeto.labmedicalbackend.controllers.dtos.usuario.RequestAtualizarUsuarioDTO;
import projeto.labmedicalbackend.controllers.dtos.usuario.RequestCriarUsuarioDTO;
import projeto.labmedicalbackend.mappers.UsuarioMapper;
import projeto.labmedicalbackend.models.Usuario;
import projeto.labmedicalbackend.repositories.UsuarioRepository;

import java.util.Objects;

@Service
public class UsuarioService {
    private final UsuarioRepository repository;
    private final UsuarioMapper mapper;

    public UsuarioService(UsuarioRepository repository, UsuarioMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Usuario salvarUsuario(RequestCriarUsuarioDTO request) {
        //otimizar o if
        /*
        Usuario usuario = repository.findUsuarioByCpf(request.getCpf()).orElse(null);//Throw(() -> new IllegalArgumentException("CPF já existe"));
        if(Objects.isNull(usuario)) {
            repository.save(mapper.map(request));
        }*/
        if (!repository.existsUsuarioByCpf(request.getCpf())) {
            return repository.save(mapper.map(request));
        } else {
            throw new IllegalArgumentException("CPF já existe");//montar body com 409 conflict
        }
    }

    public Usuario alterarUsuario(RequestAtualizarUsuarioDTO request, Long id) {
        Usuario usuario = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Usuario não encontrado"));
        mapper.update(usuario, request);
        return repository.save(usuario);
    }

    public Usuario alterarSenha(RequestAtualizarSenhaDTO request, Long id){
        Usuario usuario = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Usuario não encontrado"));
        mapper.update(usuario, request);
        return repository.save(usuario);
    }
}