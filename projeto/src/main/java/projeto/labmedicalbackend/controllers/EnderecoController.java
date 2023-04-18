package projeto.labmedicalbackend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import projeto.labmedicalbackend.controllers.dtos.endereco.EnderecoBuscarDTO;
import projeto.labmedicalbackend.controllers.dtos.endereco.EnderecoCriarDTO;
import projeto.labmedicalbackend.models.Endereco;
import projeto.labmedicalbackend.services.EnderecoService;

import java.util.List;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController {
    private final EnderecoService service;

    public EnderecoController(EnderecoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<EnderecoBuscarDTO>> buscarEnderecos(){
        return ResponseEntity.ok().body(service.procurarEnderecos());
    }

    @PostMapping
    public ResponseEntity<Endereco> cadastrarEndereco(@RequestBody @Validated EnderecoCriarDTO request) {
        return ResponseEntity.ok().body(service.salvarEndereco(request));
    }
}
