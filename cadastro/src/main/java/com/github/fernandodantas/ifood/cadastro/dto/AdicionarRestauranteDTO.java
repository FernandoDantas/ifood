package com.github.fernandodantas.ifood.cadastro.dto;

import com.github.fernandodantas.ifood.cadastro.Localizacao;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

public class AdicionarRestauranteDTO {

    public String proprietario;

    public String cnpj;

    public String nome;

    public LocalizacaoDTO localizacao;

}
