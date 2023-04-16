package projeto.labmedicalbackend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projeto.labmedicalbackend.controllers.dtos.RequestCriarUsuarioDTO;
import projeto.labmedicalbackend.services.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    private final UsuarioService service;
    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> cadastrarUsuario(@RequestBody RequestCriarUsuarioDTO request){
        service.salvarUsuario(request);
        return ResponseEntity.ok().build();
    }
}
