package br.com.solinftec.Treinamento.Service;

import br.com.solinftec.Treinamento.dto.cooperativa.SaveCooperativaDto;
import br.com.solinftec.Treinamento.dto.equipamento.EquipamentoDto;
import br.com.solinftec.Treinamento.dto.equipamento.SaveEquipamentoDto;
import br.com.solinftec.Treinamento.dto.monitoramento.SaveMonitoramentoDto;
import br.com.solinftec.Treinamento.model.Cooperativa;
import br.com.solinftec.Treinamento.model.Equipamento;
import br.com.solinftec.Treinamento.model.Monitoramento;
import br.com.solinftec.Treinamento.repository.EquipamentoRepository;
import br.com.solinftec.Treinamento.repository.MonitoramentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor


public class EquipamentoService {
    private final EquipamentoRepository repository;

    public SaveMonitoramentoDto update( SaveMonitoramentoDto saveMonitoramentoDto) throws Exception {

        Optional<Equipamento> equipamento = repository.findById(saveMonitoramentoDto.getEquipamento().getId());

        if(equipamento.isPresent()) {
            repository.save(saveMonitoramentoDto.pegarLoc());
            return saveMonitoramentoDto;
        } else {
            throw new Exception("COOPERATIVA_NOT_FOUND");
        }
    }

    public List<EquipamentoDto> getAllEquipamentos() {
        return repository.findAll()
                .stream()
                .map(equipamento -> new EquipamentoDto(equipamento))
                .collect(Collectors.toList());
    }


    public SaveEquipamentoDto saveEquipamento(SaveEquipamentoDto saveEquipamentoDto) {
        Equipamento equipamento = saveEquipamentoDto.pegarModel();
        repository.save(equipamento);
        saveEquipamentoDto.setId(equipamento.getId());
        return saveEquipamentoDto;
    }


    public void deletarEquipamento(Long idEquipamento) throws Exception {

        Optional<Equipamento> equipamento = repository.findById(idEquipamento);

        if(equipamento.isPresent()) {
            repository.delete(equipamento.get());
        } else {
            throw new Exception("EQUIPAMENTO_NOT_FOUND");
        }
    }
}
