package br.com.solinftec.Treinamento.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

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
    @JsonManagedReference
    private Fazendeiro fazendeiro;

    @OneToMany(mappedBy = "ID_FAZENDA")
    @JsonBackReference
    private List<OrdemServico> ordeServico;


    public Fazenda(Fazenda fazenda) {
    }

    public Fazenda() {

    }

}
