package com.dh.hibernate.aula33.service;

import com.dh.hibernate.aula33.model.Jogador;
import com.dh.hibernate.aula33.repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class JogadorServiceImpl implements JogadorService {

    JogadorRepository jogadorRepository;

    @Autowired
    public JogadorServiceImpl(JogadorRepository jogadorRepository) {
        this.jogadorRepository = jogadorRepository;
    }

    @Override
    public Optional<Jogador> buscar(Integer id) {
        return jogadorRepository.findById(id);
    }

    @Override
    public List<Jogador> buscarTodos() {
        return jogadorRepository.findAll();
    }

    @Override
    public void salvar(Jogador jogador) {
        jogadorRepository.save(jogador);
    }

    @Override
    public void excluir(Integer id) {
        jogadorRepository.deleteById(id);
    }
}
