package com.comerce.stockApi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter 
@AllArgsConstructor 
@NoArgsConstructor
@Entity
@Table(name = "produto")
public class Produto {
    
    @Column(name = "id_produto")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String nome;
    
    private float preco;

    public Produto(String _nome, float _preco) {
        this.nome = _nome;
        this.preco = _preco;
    }  

}
