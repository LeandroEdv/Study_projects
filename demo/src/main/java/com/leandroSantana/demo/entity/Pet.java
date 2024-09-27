package com.leandroSantana.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pets")
// lombok
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome", nullable = true)
    private String nome;

    @Column(name = "especie", nullable = true)
    private String especie;

    private char sexo;
    private int idade;
    private String raca;
    private char porte;

}
