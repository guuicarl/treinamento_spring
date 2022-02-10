package br.com.solinftec.Treinamento.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "TIPO_SERVICO")
public class TipoServico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "DESCRICAO")
    private String descricao;

    @OneToMany(mappedBy = "TIPO_SERVICO")
    @JsonBackReference
    private List<OrdemServico> ordemServico;
}
