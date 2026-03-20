package com.Carreira.PA_GerenciadorDeTarefas.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "TBL_Tarefa")
public class TarefaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="Descrição Tarefa")
    private String descricao;
    @Column(name="Data Vencimento Tarefa")
    private LocalDate vencimentoTarefa;
    @Column(name="Status Tarefa")
    private Boolean statusTarefa;

    public TarefaModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getVencimentoTarefa() {
        return vencimentoTarefa;
    }

    public void setVencimentoTarefa(LocalDate vencimentoTarefa) {
        this.vencimentoTarefa = vencimentoTarefa;
    }

    public Boolean getStatusTarefa() {
        return statusTarefa;
    }

    public void setStatusTarefa(Boolean statusTarefa) {
        this.statusTarefa = statusTarefa;
    }
}

