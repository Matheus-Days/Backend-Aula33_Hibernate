package com.dh.hibernate.aula33.controller;

import com.dh.hibernate.aula33.model.Time;
import com.dh.hibernate.aula33.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RequestMapping("/times")
@RestController
public class TimeController {

    private final TimeService timeService;

    @Autowired
    public TimeController(TimeService timeService) {
        this.timeService = timeService;
    }

    @GetMapping
    public ResponseEntity<List<Time>> buscarTodos() {
        return ResponseEntity.ok(timeService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Time> buscar(@PathVariable Integer id){

        return ResponseEntity.ok(timeService.buscar(id).orElseThrow(
                ()-> new ResponseStatusException(NOT_FOUND, "Time não encontrado")
        ));
    }

    @PostMapping
    public ResponseEntity<?> salvarJogador(@RequestBody Time t) {
        timeService.salvar(t);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Integer id) {
        ResponseEntity<String> responseEntity = null;

        if(timeService.buscar(id).isPresent()) {
            timeService.excluir(id);
            responseEntity = ResponseEntity.status(NO_CONTENT).body("Time excluído.");
        } else {
            responseEntity = ResponseEntity.status(NOT_FOUND).build();
        }

        return responseEntity;
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizar(@PathVariable Integer id, @RequestBody Time t) {
        ResponseEntity<String> responseEntity = null;

        if(timeService.buscar(id).isPresent()) {
            t.setId(id);
            timeService.salvar(t);
            responseEntity = new ResponseEntity<>(OK);
        } else {
            responseEntity = ResponseEntity.status(NOT_FOUND).body("Time não encontrado.");
        }

        return responseEntity;
    }


}
