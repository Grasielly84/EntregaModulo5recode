package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Destino {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String nome;
    private Integer valor;
    

    public Destino () {}

    public Destino(Long id, String nome, Integer valor) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Integer getValor() {
        return valor;
    }
    public void setValor(Integer valor) {
        this.valor = valor;
    }
    
    
}
