package projeto.labmedicalbackend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import projeto.labmedicalbackend.controllers.dtos.consulta.RequestAtualizarConsultaDTO;
import projeto.labmedicalbackend.controllers.dtos.consulta.RequestCriarConsultaDTO;
import projeto.labmedicalbackend.controllers.dtos.consulta.ResponseBuscarConsultaDTO;
import projeto.labmedicalbackend.services.ConsultaService;

@RestController
@RequestMapping("/api/consultas")
public class ConsultaController {
    private final ConsultaService service;
    public ConsultaController(ConsultaService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseBuscarConsultaDTO> buscarConsultaById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.procurarConsultaById(id));
    }
    @PostMapping
    public ResponseEntity<ResponseBuscarConsultaDTO> criarConsulta(@RequestBody @Validated RequestCriarConsultaDTO request){
        return ResponseEntity.status(201).body(service.salvarConsulta(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseBuscarConsultaDTO> atualizarConsulta(@RequestBody @Validated RequestAtualizarConsultaDTO request, @PathVariable Long id){
        return ResponseEntity.ok().body(service.alterarConsulta(request,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity removerConsulta(@PathVariable Long id){
        service.deletarConsulta(id);
        return ResponseEntity.noContent().build();
    }

}
