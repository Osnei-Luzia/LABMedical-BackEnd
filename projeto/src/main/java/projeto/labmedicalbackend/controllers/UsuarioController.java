package projeto.labmedicalbackend.controllers;

import org.springframework.http.ResponseEntity;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import projeto.labmedicalbackend.controllers.dtos.usuario.RequestAtualizarSenhaDTO;
import projeto.labmedicalbackend.controllers.dtos.usuario.RequestAtualizarUsuarioDTO;
import projeto.labmedicalbackend.controllers.dtos.usuario.RequestCriarUsuarioDTO;
import projeto.labmedicalbackend.models.Usuario;
import projeto.labmedicalbackend.services.UsuarioService;


@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody @Validated RequestCriarUsuarioDTO request, UriComponentsBuilder uriBuilder) {
        return ResponseEntity.status(201).body(service.salvarUsuario(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@RequestBody @Validated RequestAtualizarUsuarioDTO request, @PathVariable Long id) {
        return ResponseEntity.ok().body(service.alterarUsuario(request, id));
    }

    @PutMapping("/{id}/senha")
    public ResponseEntity<Usuario> atualizarSenha(@RequestBody @Validated RequestAtualizarSenhaDTO request, @PathVariable Long id) {
        return ResponseEntity.ok().body(service.alterarSenha(request, id));
    }
}
