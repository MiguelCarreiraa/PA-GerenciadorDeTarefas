package com.Carreira.PA_GerenciadorDeTarefas.controllers;


import com.Carreira.PA_GerenciadorDeTarefas.models.TarefaModel;
import com.Carreira.PA_GerenciadorDeTarefas.services.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @GetMapping
    public List<TarefaModel> findAll(){
        return tarefaService.findAll();
    }

    @PostMapping
    public TarefaModel criarTarefa(@RequestBody TarefaModel tarefaModel){
        return tarefaService.criar(tarefaModel);
    }

    @GetMapping("/{id}")
    public Optional<TarefaModel> buscarTarefa(@PathVariable Long id){
        return tarefaService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public TarefaModel atualizarTarefa(@PathVariable Long id, @RequestBody TarefaModel tarefaModel){
        return tarefaService.atualizar(id, tarefaModel);
    }

    @DeleteMapping("/{id}")
    public void deletarTarefa(@PathVariable Long id){
        tarefaService.deletar(id);
    }
}

