package br.com.solinftec.Treinamento.Service;

import br.com.solinftec.Treinamento.dto.tipoEquipamento.SaveTipoEquipamentoDto;
import br.com.solinftec.Treinamento.model.TipoEquipamento;
import br.com.solinftec.Treinamento.repository.TipoEquipamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TipoEquipamentoService {
    private final TipoEquipamentoRepository repository;



    public SaveTipoEquipamentoDto saveTipoEquipamentoDto(SaveTipoEquipamentoDto saveTipoEquipamentoDto) {
        TipoEquipamento tipoEquipamento = saveTipoEquipamentoDto.pegarModelTE();
        repository.save(tipoEquipamento);
        saveTipoEquipamentoDto.setId(tipoEquipamento.getId());
        return saveTipoEquipamentoDto;
    }

    public SaveTipoEquipamentoDto updateTEquipamento(SaveTipoEquipamentoDto saveTipoEquipamentoDto) throws Exception {

        Optional<TipoEquipamento> tipo_equipamentoo = repository.findById(saveTipoEquipamentoDto.getId());

        if(tipo_equipamentoo.isPresent()) {
            repository.save(saveTipoEquipamentoDto.pegarModelTE());
            return saveTipoEquipamentoDto;
        } else {
            throw new Exception("TIPO_EQUIPAMENTO_NOT_FOUND");
        }
    }

    public void deletarTEquipamento(Long idTipoEQ) throws Exception {

        Optional<TipoEquipamento> tipoEquipamento = repository.findById(idTipoEQ);

        if(tipoEquipamento.isPresent()) {
            repository.delete(tipoEquipamento.get());
        } else {
            throw new Exception("TIPO_EQUIPAMENTO_NOT_FOUND");
        }
    }
}
