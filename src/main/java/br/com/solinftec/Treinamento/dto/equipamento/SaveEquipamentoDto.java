package br.com.solinftec.Treinamento.dto.equipamento;

import br.com.solinftec.Treinamento.model.Equipamento;
import lombok.Data;


@Data
public class SaveEquipamentoDto {

    private Long id;
    private String descricao;
    private Float latitude;
    private Float longitude;
    private Boolean ativo;

    public Equipamento pegarModel() {
        Equipamento equipamento = new Equipamento();
        equipamento.setAtivo(true);
        equipamento.setId(this.id);
        equipamento.setDescricao(this.descricao);
        equipamento.setLatitude(this.latitude);
        equipamento.setLongitude(this.longitude);
        return equipamento;
    }

}