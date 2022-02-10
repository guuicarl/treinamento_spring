package br.com.solinftec.Treinamento.Service;


import br.com.solinftec.Treinamento.dto.cooperativa.SaveCooperativaDto;
import br.com.solinftec.Treinamento.dto.monitoramento.SaveMonitoramentoDto;
import br.com.solinftec.Treinamento.model.Cooperativa;
import br.com.solinftec.Treinamento.model.Equipamento;
import br.com.solinftec.Treinamento.model.Fazendeiro;
import br.com.solinftec.Treinamento.model.Monitoramento;
import br.com.solinftec.Treinamento.repository.MonitoramentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MonitoramentoService {
    private final MonitoramentoRepository repository;

    public SaveMonitoramentoDto save(SaveMonitoramentoDto saveMonitoramentoDto) {
        Monitoramento monitoramento = saveMonitoramentoDto.pegarModel();
        repository.save(monitoramento);
        saveMonitoramentoDto.setId(monitoramento.getId());
        return saveMonitoramentoDto;
    }

    public SaveMonitoramentoDto update(SaveMonitoramentoDto saveMonitoramentoDto) throws Exception {

        Optional<Monitoramento> monitoramento = repository.findById(saveMonitoramentoDto.getId());

        if(monitoramento.isPresent()) {
            repository.save(saveMonitoramentoDto.pegarModel());
            return saveMonitoramentoDto;
        } else {
            throw new Exception("MONITORAMENTO_NOT_FOUND");
        }
    }

    public void deletar(Long idMonitoramento) throws Exception {

        Optional<Monitoramento> monitoramento = repository.findById(idMonitoramento);

        if(monitoramento.isPresent()) {
            repository.delete(monitoramento.get());
        } else {
            throw new Exception("MONITORAMENTO_NOT_FOUND");
        }
    }

}
