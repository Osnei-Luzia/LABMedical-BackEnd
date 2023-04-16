package projeto.labmedicalbackend.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import projeto.labmedicalbackend.controllers.dtos.RequestCriarUsuarioDTO;
import projeto.labmedicalbackend.mappers.UsuarioMapper;
import projeto.labmedicalbackend.repositories.UsuarioRepository;

@Service
public class UsuarioService {
    private final UsuarioRepository repository;
    private final UsuarioMapper mapper;

    public UsuarioService(UsuarioRepository repository, UsuarioMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public ResponseEntity<Void> salvarUsuario(RequestCriarUsuarioDTO request) {
        repository.save(mapper.map(request));
        return ResponseEntity.ok().build();  //created("construir uri do get").build();
    }
}