package com.credenciamento.CredenciamentoController;

import com.credenciamento.DTO.CredenciamentoDTO;
import com.credenciamento.Entity.Credenciamento;
import com.credenciamento.Service.CredenciamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/credenciamento")
public class CredenciamentoController {

    @Autowired
    private CredenciamentoService credenciamentoService;

    // Listar todos os credenciamentos
    @GetMapping("/list")
    public List<Credenciamento> getAllCredenciamentos() {
        return credenciamentoService.getAllCredenciamentos();
    }

    // Criar um novo credenciamento
    @PostMapping("/create")
    public ResponseEntity<String> createCredenciamento(@RequestBody CredenciamentoDTO credenciamentoDTO) {
        try {
            credenciamentoService.createCredenciamento(credenciamentoDTO);
            return ResponseEntity.status(HttpStatus.OK).body("Credenciamento created successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create credenciamento: " + e.getMessage());
        }
    }

    // Obter um credenciamento pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Credenciamento> getCredenciamento(@PathVariable int id) {
        Credenciamento credenciamento = credenciamentoService.getCredenciamento(id);
        if (credenciamento != null) {
            return ResponseEntity.ok(credenciamento);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
