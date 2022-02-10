package br.com.solinftec.Treinamento.dto.tipoEquipamento;

import br.com.solinftec.Treinamento.model.TipoEquipamento;
import lombok.Data;

@Data
public class TipoEquipamentoDto {

    private Long id;
    private String descricao;

    public TipoEquipamentoDto(TipoEquipamento tipoEquipamento) {
        this.id = tipoEquipamento.getId();
        this.descricao = tipoEquipamento.getDescricao();
    }
}