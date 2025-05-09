package controller;

import entity.Emissao;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.EmissaoService;

import java.util.List;

@RestController
@RequestMapping("/emissoes")
public class EmissaoController {

    @Autowired
    private EmissaoService service;

    @GetMapping
    public List<Emissao> listarTodas() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Emissao> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Emissao> criar(@Valid @RequestBody Emissao emissao) {
        return ResponseEntity.ok(service.criar(emissao));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Emissao> atualizar(@PathVariable Long id, @Valid @RequestBody Emissao emissao) {
        if (!service.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(service.atualizar(id, emissao));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!service.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
