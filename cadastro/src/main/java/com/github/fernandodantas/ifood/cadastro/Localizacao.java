package com.github.fernandodantas.ifood.cadastro;

import javax.persistence.*;

@Entity
@Table(name = "restaurante")
public class Localizacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public Double latitude;

    public Double longitude;
}