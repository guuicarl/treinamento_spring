package br.com.solinftec.Treinamento.dto.equipamento;
import br.com.solinftec.Treinamento.model.Equipamento;
import lombok.Data;

@Data
public class EquipamentoDto {

    private Long id;
    private String descricao;
    private Float latitude;
    private Float longitude;
    private Boolean ativo;

    public EquipamentoDto(Equipamento equipamento) {
        this.id = equipamento.getId();
        this.descricao = equipamento.getDescricao();
        this.Longitude = equipamento.getLongitude();
        this.ativo = equipamento.getAtivo();
    }
}