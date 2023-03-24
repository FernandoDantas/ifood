package com.github.fernandodantas.ifood.cadastro.dto;

import java.math.BigDecimal;

public class PratoDTO {

    public Long id;

    public String nome;

    public String descricao;

    public RestauranteDTO restaurante;

    public BigDecimal preco;
}
