package br.com.solinftec.Treinamento.dto.ordemServico;

import br.com.solinftec.Treinamento.model.*;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Data
public class OrdemServicoDto {
    private Long id;
    private Cooperativa cooperativa;
    private Fazenda fazenda;
    private Equipamento equipamento;
    private Produto produto;
    private Date data_execucao;
    private Double rate_aplicacao;
    private Double total_aplicacao;
    private TipoServico tipoServico;

    public OrdemServicoDto(OrdemServico ordemServico){
        this.id = ordemServico.getId();
        this.cooperativa = ordemServico.getCooperativa();
        this.fazenda = ordemServico.getFazenda();
        this.equipamento = ordemServico.getEquipamento();
        this.produto = ordemServico.getProduto();
        this.data_execucao = ordemServico.getData_execucao();
        this.rate_aplicacao = ordemServico.getRate_aplicacao();
        this.total_aplicacao = ordemServico.getTotal_aplicacao();
        this.tipoServico = ordemServico.getTipoServico();

    }
}
