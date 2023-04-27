package projeto.labmedicalbackend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projeto.labmedicalbackend.controllers.dtos.ListagemDTO;
import projeto.labmedicalbackend.services.EstatisticasService;

@RestController
@RequestMapping("/api/estatisticas")
public class ListagemController {
    private final EstatisticasService service;

    public ListagemController(EstatisticasService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<ListagemDTO> buscarEstatisticas() {
        return ResponseEntity.ok().body(service.procurarEstatisticas());
    }
}
