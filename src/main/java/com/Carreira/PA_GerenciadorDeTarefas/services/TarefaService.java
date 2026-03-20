package com.Carreira.PA_GerenciadorDeTarefas.services;


import com.Carreira.PA_GerenciadorDeTarefas.models.TarefaModel;
import com.Carreira.PA_GerenciadorDeTarefas.repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public List<TarefaModel> findAll() {
        return tarefaRepository.findAll();
    }
    public TarefaModel criar(TarefaModel tarefaModel) {
        return tarefaRepository.save(tarefaModel);

    }

    public Optional<TarefaModel> buscarPorId(Long id) {
        return tarefaRepository.findById(id);
    }

    public TarefaModel atualizar(Long id,TarefaModel tarefaModel) {
        TarefaModel model =  tarefaRepository.findById(id).get();
        model.setDescricao(tarefaModel.getDescricao());
        model.setStatusTarefa(tarefaModel.getStatusTarefa());
        model.setVencimentoTarefa(tarefaModel.getVencimentoTarefa());
        return tarefaRepository.save(model);
    }

    public void deletar(Long id) {
        tarefaRepository.deleteById(id);
    }

}

