package com.dh.hibernate.aula33.service;

import com.dh.hibernate.aula33.model.Time;
import com.dh.hibernate.aula33.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class TimeServiceImpl implements TimeService{

    TimeRepository timeRepository;

    @Autowired
    public TimeServiceImpl(TimeRepository timeRepository) {
        this.timeRepository = timeRepository;
    }

    @Override
    public List<Time> buscarTodos() {
        return timeRepository.findAll();
    }

    @Override
    public Optional<Time> buscar(Integer id) {
        return timeRepository.findById(id);
    }

    @Override
    public void salvar(Time time) {
        timeRepository.save(time);
    }

    @Override
    public void excluir(Integer id) {
        timeRepository.deleteById(id);
    }

}
