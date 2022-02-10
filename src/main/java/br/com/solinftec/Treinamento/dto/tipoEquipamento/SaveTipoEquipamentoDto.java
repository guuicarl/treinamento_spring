package br.com.solinftec.Treinamento.dto.tipoEquipamento;

import br.com.solinftec.Treinamento.model.TipoEquipamento;
import lombok.Data;

@Data
public class SaveTipoEquipamentoDto {

    private Long id;
    private String descricao;


    public TipoEquipamento pegarModelTE() {
        TipoEquipamento tipoEquipamento = new TipoEquipamento();
        tipoEquipamento.setId(this.id);
        tipoEquipamento.setDescricao(this.descricao);
        return tipoEquipamento;
    }
}