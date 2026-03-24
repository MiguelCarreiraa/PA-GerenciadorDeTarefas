package com.Carreira.PA_GerenciadorDeTarefas.controllers;


import com.Carreira.PA_GerenciadorDeTarefas.models.TarefaModel;
import com.Carreira.PA_GerenciadorDeTarefas.services.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(path = "/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @GetMapping
    public ResponseEntity<List<TarefaModel>> findAllTarefa() {
        return ResponseEntity.ok(tarefaService.findAll());
    }

    @PostMapping
    public ResponseEntity<TarefaModel> criarTarefa(@RequestBody TarefaModel tarefaModel) {
        TarefaModel nova = tarefaService.criar(tarefaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(nova);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaModel> buscarTarefa(@PathVariable Long id) {
        Optional<TarefaModel> tarefa = tarefaService.buscarPorId(id);

        if (tarefa.isPresent()) {
            return ResponseEntity.ok(tarefa.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<TarefaModel> atualizarTarefa(@PathVariable Long id,
                                                       @RequestBody TarefaModel tarefaModel) {
        Optional<TarefaModel> existente = tarefaService.buscarPorId(id);

        if (existente.isPresent()) {
            TarefaModel atualizado = tarefaService.atualizar(id, tarefaModel);
            return ResponseEntity.ok(atualizado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable Long id) {
        Optional<TarefaModel> existente = tarefaService.buscarPorId(id);

        if (existente.isPresent()) {
            tarefaService.deletar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}

