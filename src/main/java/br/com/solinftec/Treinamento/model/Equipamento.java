package br.com.solinftec.Treinamento.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(mappedBy = "ID_EQUIPAMENTO")
    @JsonBackReference
    private List<Monitoramento> monitoramento;

    @OneToMany(mappedBy = "ID_EQUIPAMENTO")
    @JsonBackReference
    private List<OrdemServico> ordemServico;
}
