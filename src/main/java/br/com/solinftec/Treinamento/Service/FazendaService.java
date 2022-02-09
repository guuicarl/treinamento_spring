package br.com.solinftec.Treinamento.Service;

import br.com.solinftec.Treinamento.dto.cooperativa.SaveCooperativaDto;
import br.com.solinftec.Treinamento.dto.fazenda.FazendaDto;
import br.com.solinftec.Treinamento.dto.fazenda.GetAllFazendaDto;
import br.com.solinftec.Treinamento.dto.fazenda.SaveFazendaDto;
import br.com.solinftec.Treinamento.dto.fazendeiro.FazendeiroWithFazendaDto;
import br.com.solinftec.Treinamento.model.Cooperativa;
import br.com.solinftec.Treinamento.model.Fazenda;
import br.com.solinftec.Treinamento.model.Fazendeiro;
import br.com.solinftec.Treinamento.repository.FazendaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FazendaService {

    private final FazendaRepository repository;

    public List<GetAllFazendaDto> getAll() {
        return repository.findAll().stream()
                .map(fazenda -> new GetAllFazendaDto(fazenda))
                .collect(Collectors.toList());
    }

    public FazendaDto getFazenda(Long idFazenda) throws Exception {

        Optional<Fazenda> fazenda = repository.findById(idFazenda);

        if(fazenda.isPresent()) {
            return new FazendaDto(fazenda.get());
        } else {
            throw new Exception("FAZENDA_NOT_FOUND");
        }
    }

    public SaveFazendaDto save(SaveFazendaDto saveFazendaDto) {
        Fazenda fazenda = saveFazendaDto.pegarModel();
        repository.save(fazenda);
        saveFazendaDto.setId(fazenda.getId());
        return saveFazendaDto;
    }

    public SaveFazendaDto update(SaveFazendaDto saveFazendaDto) throws Exception {

        Optional<Fazenda> fazenda = repository.findById(saveFazendaDto.getId());

        if(fazenda.isPresent()) {
            repository.save(saveFazendaDto.pegarModel());
            return saveFazendaDto;
        } else {
            throw new Exception("FAZENDA_NOT_FOUND");
        }
    }

    public void deletar(Long idFazenda) throws Exception {

        Optional<Fazenda> fazenda = repository.findById(idFazenda);

        if(fazenda.isPresent()) {
            repository.delete(fazenda.get());
        } else {
            throw new Exception("FAZENDA_NOT_FOUND");
        }
    }
}