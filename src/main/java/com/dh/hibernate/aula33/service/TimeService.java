package com.dh.hibernate.aula33.service;

import com.dh.hibernate.aula33.model.Time;

import java.util.List;
import java.util.Optional;

public interface TimeService {

    void salvar(Time time);
    void excluir(Integer id);
    Optional<Time> buscar(Integer id);
    List<Time> buscarTodos();

}
