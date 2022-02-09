package br.com.solinftec.Treinamento.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "FAZENDA")
public class Fazenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "AREA")
    private Float area;

    @Column(name = "LATITUDE")
    private Float latitude;

    @Column(name = "LONGITUDE")
    private Float longitude;

    @ManyToOne
    @JoinColumn(name = "ID_FAZENDEIRO")
    private Fazendeiro fazendeiro;

}
