package br.com.solinftec.Treinamento.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "ORDEM_SERVICO")
public class OrdemServico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "ID_COOPERATIVA")
    private Cooperativa cooperativa;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "ID_FAZENDA")
    private Fazenda fazenda;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "ID_EQUIPAMENTO")
    private Equipamento equipamento;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "ID_PRODUTO")
    private Produto produto;

    @Column(name = "DATA_EXECUCAO")
    private Date data_execucao;

    @Column(name = "RATE_APLICACAO")
    private Double rate_aplicacao;

    @Column(name = "TOTAL_APLICACAO")
    private Double total_aplicacao;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "TIPO_SERVICO")
    private TipoServico tipoServico;

    @OneToMany(mappedBy = "ID_ORDEM_SERVICO")
    @JsonBackReference
    private List<Monitoramento> monitoramento;
}
