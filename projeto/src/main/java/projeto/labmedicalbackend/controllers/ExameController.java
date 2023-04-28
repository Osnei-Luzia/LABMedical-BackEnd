package projeto.labmedicalbackend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import projeto.labmedicalbackend.controllers.dtos.exame.RequestAtualizarExameDTO;
import projeto.labmedicalbackend.controllers.dtos.exame.RequestCriarExameDTO;
import projeto.labmedicalbackend.controllers.dtos.exame.ResponseBuscarExameDTO;
import projeto.labmedicalbackend.models.Exame;
import projeto.labmedicalbackend.services.ExameService;

@RestController
@RequestMapping("/api/exames")
public class ExameController {
    private final ExameService service;

    public ExameController(ExameService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseBuscarExameDTO> buscarExameById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.procurarExameById(id));
    }

    @PostMapping
    public ResponseEntity<ResponseBuscarExameDTO> criarExame(@RequestBody @Validated RequestCriarExameDTO request) {
        return ResponseEntity.status(201).body(service.salvarExame(request));//fazer created
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseBuscarExameDTO> atualizarExame(@RequestBody @Validated RequestAtualizarExameDTO request, @PathVariable Long id){
        return ResponseEntity.ok().body(service.alterarExame(request,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity removerExame(@PathVariable Long id){
        service.deletarExame(id);
        return ResponseEntity.noContent().build();
    }
}
