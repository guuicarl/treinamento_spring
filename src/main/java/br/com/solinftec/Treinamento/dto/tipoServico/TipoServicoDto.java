package br.com.solinftec.Treinamento.dto.tipoServico;

import br.com.solinftec.Treinamento.model.TipoServico;
import lombok.Data;

@Data
public class TipoServicoDto {

    private Long id;
    private String descricao;


    public TipoServicoDto(TipoServico tipoServico) {
        this.id = tipoServico.getId();
        this.descricao = tipoServico.getDescricao();
    }
}
