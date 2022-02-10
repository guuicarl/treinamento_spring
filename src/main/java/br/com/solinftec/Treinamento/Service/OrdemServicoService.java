package br.com.solinftec.Treinamento.Service;

import br.com.solinftec.Treinamento.dto.ordemServico.SaveOrdemDto;
import br.com.solinftec.Treinamento.model.OrdemServico;
import br.com.solinftec.Treinamento.repository.OrdemServicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrdemServicoService {
    private final OrdemServicoRepository repository;

    public SaveOrdemDto saveOrdem(SaveOrdemDto saveOrdemDto) {
        OrdemServico ordemServico = saveOrdemDto.pegarModel();
        repository.save(ordemServico);
        saveOrdemDto.setId(ordemServico.getId());
        return saveOrdemDto;
    }

    public SaveOrdemDto updateOrdem(SaveOrdemDto saveOrdemDto) throws Exception {

        Optional<OrdemServico> ordem_servico = repository.findById(saveOrdemDto.getId());

        if(ordem_servico.isPresent()) {
            repository.save(saveOrdemDto.pegarModel());
            return saveOrdemDto;
        } else {
            throw new Exception("ORDEM_NOT_FOUND");
        }
    }

    public void deletarOrdem(Long idOrdem) throws Exception {

        Optional<OrdemServico> ordem_servico = repository.findById(idOrdem);

        if(ordem_servico.isPresent()) {
            repository.delete(ordem_servico.get());
        } else {
            throw new Exception("ORDEM_NOT_FOUND");
        }
    }
}
