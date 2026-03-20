package com.Carreira.PA_GerenciadorDeTarefas.repositories;


import com.Carreira.PA_GerenciadorDeTarefas.models.TarefaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<TarefaModel, Long> {
}
