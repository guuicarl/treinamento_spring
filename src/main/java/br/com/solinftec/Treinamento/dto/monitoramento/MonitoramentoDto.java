package br.com.solinftec.Treinamento.dto.monitoramento;
import br.com.solinftec.Treinamento.model.Equipamento;
import br.com.solinftec.Treinamento.model.Monitoramento;
import br.com.solinftec.Treinamento.model.OrdemServico;
import lombok.Data;

import java.util.Date;

@Data
public class MonitoramentoDto {

    private Long id;
    private Float latitude;
    private Float longitude;
    private Date data_Hora;
    private Equipamento equipamento;
    private OrdemServico ordemServico;


    public MonitoramentoDto(Monitoramento monitoramento) {
        this.id = monitoramento.getId();
        this.latitude=monitoramento.getLatitude();
        this.longitude=monitoramento.getLongitude();
        this.data_Hora = monitoramento.getData_hora();
        this.equipamento=monitoramento.getEquipamento();
        this.ordemServico = monitoramento.getOrdemServico();
    }
}
