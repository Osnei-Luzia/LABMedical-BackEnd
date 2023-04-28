package projeto.labmedicalbackend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import projeto.labmedicalbackend.controllers.dtos.paciente.RequestAtualizarPacienteDTO;
import projeto.labmedicalbackend.controllers.dtos.paciente.RequestCriarPacienteDTO;
import projeto.labmedicalbackend.controllers.dtos.paciente.ResponseBuscarPacienteDTO;
import projeto.labmedicalbackend.models.Paciente;
import projeto.labmedicalbackend.services.PacienteService;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    private final PacienteService service;

    public PacienteController(PacienteService service) {
        this.service = service;
    }
    @GetMapping(params = "nome")
    public ResponseEntity<ResponseBuscarPacienteDTO> buscarPacientesByNome(@RequestParam String nome){
        return ResponseEntity.ok().body(service.procurarPacientesByNome(nome));
    }
    @GetMapping
    public ResponseEntity<List<ResponseBuscarPacienteDTO>> buscarPacientes(){
        return ResponseEntity.ok().body(service.procurarPacientes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseBuscarPacienteDTO> buscarPacienteById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.procurarPacienteById(id));
    }

    @PostMapping
    public ResponseEntity<ResponseBuscarPacienteDTO> criarPaciente(@RequestBody @Validated RequestCriarPacienteDTO request) {
        return ResponseEntity.status(201).body(service.salvarPaciente(request));//fazer created
    }

    @PutMapping("/{idPaciente}")
    public ResponseEntity<Paciente> atualizarPaciente(@RequestBody @Validated RequestAtualizarPacienteDTO request, @PathVariable Long idPaciente) {
        return ResponseEntity.ok().body(service.alterarPaciente(request, idPaciente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity removerPaciente(@PathVariable Long id){
        service.deletarPaciente(id);
        return ResponseEntity.noContent().build();
    }
}
