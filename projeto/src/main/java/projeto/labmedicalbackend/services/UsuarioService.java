package projeto.labmedicalbackend.services;

import org.springframework.stereotype.Service;
import projeto.labmedicalbackend.controllers.dtos.usuario.RequestAtualizarSenhaDTO;
import projeto.labmedicalbackend.controllers.dtos.usuario.RequestAtualizarUsuarioDTO;
import projeto.labmedicalbackend.controllers.dtos.usuario.RequestCriarUsuarioDTO;
import projeto.labmedicalbackend.exceptions.CpfExistsException;
import projeto.labmedicalbackend.exceptions.DataExistsException;
import projeto.labmedicalbackend.services.mappers.UsuarioMapper;
import projeto.labmedicalbackend.models.Usuario;
import projeto.labmedicalbackend.repositories.UsuarioRepository;

@Service
public class UsuarioService {
    private final UsuarioRepository repository;
    private final UsuarioMapper mapper;

    public UsuarioService(UsuarioRepository repository, UsuarioMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Usuario salvarUsuario(RequestCriarUsuarioDTO request) {
        if (!repository.existsUsuarioByCpf(request.getCpf())) {
            return repository.save(mapper.map(request));
        }
        throw new CpfExistsException("CPF em uso por outro usuário");
    }

    public Usuario alterarUsuario(RequestAtualizarUsuarioDTO request, Long id) {
        Usuario usuario = repository.findById(id).orElseThrow(() -> new DataExistsException("Usuario não encontrado"));
        mapper.update(usuario, request);
        return repository.save(usuario);
    }

    public Usuario alterarSenha(RequestAtualizarSenhaDTO request, Long id) {
        Usuario usuario = repository.findById(id).orElseThrow(() -> new DataExistsException("Usuario não encontrado"));
        mapper.update(usuario, request);
        return repository.save(usuario);
    }
}