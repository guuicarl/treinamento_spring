package br.com.solinftec.Treinamento.dto.monitoramento;

import br.com.solinftec.Treinamento.model.Cooperativa;
import br.com.solinftec.Treinamento.model.Equipamento;
import br.com.solinftec.Treinamento.model.Fazendeiro;
import br.com.solinftec.Treinamento.model.Monitoramento;
import lombok.Data;

import javax.persistence.Column;
import java.sql.Timestamp;
import java.util.stream.Collectors;

@Data
public class SaveMonitoramentoDto {
    private Long id;
    private Float latitude;
    private Float longitude;
    private Equipamento equipamento;

    public Monitoramento pegarModel() {
        Monitoramento monitoramento = new Monitoramento();
        monitoramento.setId(this.id);
        monitoramento.setLatitude(this.latitude);
        monitoramento.setLongitude(this.longitude);
        monitoramento.setEquipamento(this.equipamento);
        return monitoramento;
    }

    public Equipamento pegarLoc() {
        Equipamento equipamento = new Equipamento();
        equipamento.setId(equipamento.getId());
        equipamento.setLatitude(this.latitude);
        equipamento.setLongitude(this.longitude);
        return equipamento;
    }
}


