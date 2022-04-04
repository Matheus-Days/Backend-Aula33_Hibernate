package com.dh.hibernate.aula33.controller;

import com.dh.hibernate.aula33.model.Jogador;
import com.dh.hibernate.aula33.service.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {

    private final JogadorService jogadorService;

    @Autowired
    public JogadorController(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }

    @GetMapping
    public ResponseEntity<List<Jogador>> buscarTodos() {
        return ResponseEntity.ok(jogadorService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jogador> buscar(@PathVariable Integer id){

        return ResponseEntity.ok(jogadorService.buscar(id).orElseThrow(
                ()-> new ResponseStatusException(NOT_FOUND, "Jogador não encontrado")
        ));
    }

    @PostMapping
    public ResponseEntity<?> salvarJogador(@RequestBody Jogador j) {
        jogadorService.salvar(j);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Integer id) {
        ResponseEntity<String> responseEntity = null;

        if(jogadorService.buscar(id).isPresent()) {
            jogadorService.excluir(id);
            responseEntity = ResponseEntity.status(NO_CONTENT).body("Jogador excluída");
        } else {
            responseEntity = ResponseEntity.status(NOT_FOUND).build();
        }

        return responseEntity;
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizar(@PathVariable Integer id, @RequestBody Jogador j) {
        ResponseEntity<String> responseEntity = null;

        if(jogadorService.buscar(id).isPresent()) {
            j.setId(id);
            jogadorService.salvar(j);
            responseEntity = new ResponseEntity<>(OK);
        } else {
            responseEntity = ResponseEntity.status(NOT_FOUND).body("Jogador não encontrado.");
        }

        return responseEntity;
    }

}
