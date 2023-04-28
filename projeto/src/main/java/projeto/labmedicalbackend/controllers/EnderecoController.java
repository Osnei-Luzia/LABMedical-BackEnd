package projeto.labmedicalbackend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import projeto.labmedicalbackend.controllers.dtos.endereco.RequestCriarEnderecoDTO;
import projeto.labmedicalbackend.controllers.dtos.endereco.ResponseBuscarEnderecoDTO;
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
    public ResponseEntity<List<ResponseBuscarEnderecoDTO>> buscarEnderecos() {
        return ResponseEntity.ok().body(service.procurarEnderecos());
    }

    @GetMapping("/{id}")
    public Endereco buscarEnderecoById(@PathVariable Long id) {
        return service.procurarEnderecoById(id);
    }

    @PostMapping
    public ResponseEntity<Endereco> cadastrarEndereco(@RequestBody @Validated RequestCriarEnderecoDTO request) {
        return ResponseEntity.status(201).body(service.salvarEndereco(request));
    }
}
