package br.com.solinftec.Treinamento.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "EQUIPAMENTO")
public class Equipamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "LATITUDE")
    private Float latitude;

    @Column(name = "LONGITUDE")
    private Float longitude;

    @Column(name = "ATIVO")
    private Boolean ativo;

    @ManyToOne
    @JoinColumn(name = "ID_TIPO_EQUIPAMENTO")
    private TipoEquipamento tipoEquipamento;
}
