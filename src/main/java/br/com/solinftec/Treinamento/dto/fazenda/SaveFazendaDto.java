package br.com.solinftec.Treinamento.dto.fazenda;

import br.com.solinftec.Treinamento.model.Fazenda;
import lombok.Data;

import javax.persistence.Column;

@Data
public class SaveFazendaDto {
    private Long id;
    private String descricao;
    private Float area;
    private Float latitude;
    private Float longitude;

    public Fazenda pegarModel(){
        Fazenda fazenda = new Fazenda();
        fazenda.setId(this.id);
        fazenda.setDescricao(this.descricao);
        fazenda.setArea(this.area);
        fazenda.setLatitude(this.latitude);
        fazenda.setLongitude(this.longitude);
        return new Fazenda();
    }
}
