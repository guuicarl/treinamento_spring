package br.com.solinftec.Treinamento.Service;

import br.com.solinftec.Treinamento.dto.tipoServico.SaveTipoServicoDto;
import br.com.solinftec.Treinamento.model.TipoServico;
import br.com.solinftec.Treinamento.repository.TipoServicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TipoServicoService {
    private final TipoServicoRepository repository;

    public SaveTipoServicoDto saveTServico(SaveTipoServicoDto tipoServicoDto) {
        TipoServico tipoServico = tipoServicoDto.pegarModel();
        repository.save(tipoServico);
        tipoServico.setId(tipoServico.getId());
        return tipoServicoDto;
    }

    public SaveTipoServicoDto updateTServico(SaveTipoServicoDto saveTipoServicoDto) throws Exception {

        Optional<TipoServico> tipo_servico = repository.findById(saveTipoServicoDto.getId());

        if(tipo_servico.isPresent()) {
            repository.save(saveTipoServicoDto.pegarModel());
            return saveTipoServicoDto;
        } else {
            throw new Exception("TIPO_NOT_FOUND");
        }
    }

    public void deletarTServico(Long idServico) throws Exception {

        Optional<TipoServico> tipoServico = repository.findById(idServico);

        if(tipoServico.isPresent()) {
            repository.delete(tipoServico.get());
        } else {
            throw new Exception("TIPO_NOT_FOUND");
        }
    }
}

