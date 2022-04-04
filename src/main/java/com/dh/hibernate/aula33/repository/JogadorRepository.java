package com.dh.hibernate.aula33.repository;

import com.dh.hibernate.aula33.model.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogadorRepository extends JpaRepository<Jogador, Integer> {
}
