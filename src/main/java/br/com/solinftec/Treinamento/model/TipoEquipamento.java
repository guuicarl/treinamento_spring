package br.com.solinftec.Treinamento.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TIPO_EQUIPAMENTO")
public class TipoEquipamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "DESCRICAO")
    private String descricao;
}
