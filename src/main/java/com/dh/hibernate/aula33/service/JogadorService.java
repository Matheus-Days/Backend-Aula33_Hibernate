package com.dh.hibernate.aula33.service;

import com.dh.hibernate.aula33.model.Jogador;

import java.util.List;
import java.util.Optional;

public interface JogadorService {

    List<Jogador> buscarTodos();
    Optional<Jogador> buscar(Integer id);
    void salvar(Jogador jogador);
    void excluir(Integer id);

}
