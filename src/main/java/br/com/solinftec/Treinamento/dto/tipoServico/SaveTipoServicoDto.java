package br.com.solinftec.Treinamento.dto.tipoServico;

import br.com.solinftec.Treinamento.model.TipoServico;
import lombok.Data;


@Data
public class SaveTipoServicoDto {


    private Long id;
    private String descricao;


    public TipoServico pegarModel() {
        TipoServico tipoServico = new TipoServico();
        tipoServico.setId(this.id);
        tipoServico.setDescricao(this.descricao);
        return tipoServico;
    }

}
