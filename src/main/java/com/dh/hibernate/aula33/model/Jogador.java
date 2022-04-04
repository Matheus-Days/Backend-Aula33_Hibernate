package com.dh.hibernate.aula33.model;

import javax.persistence.*;

@Table(name = "jogadores")
@Entity
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String jogador, posicao;
    private double peso, altura;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "time_id")
    private Time time;

    public Jogador() {
    }

    public Jogador(Integer id, String jogador, String posicao, double peso, double altura, Time time) {
        this.id = id;
        this.jogador = jogador;
        this.posicao = posicao;
        this.peso = peso;
        this.altura = altura;
        this.time = time;
    }

    public Jogador(String jogador, String posicao, double peso, double altura, Time time) {
        this.jogador = jogador;
        this.posicao = posicao;
        this.peso = peso;
        this.altura = altura;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJogador() {
        return jogador;
    }

    public void setJogador(String jogador) {
        this.jogador = jogador;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
