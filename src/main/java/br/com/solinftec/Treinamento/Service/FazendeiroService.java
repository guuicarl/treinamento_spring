package br.com.solinftec.Treinamento.Service;

import br.com.solinftec.Treinamento.dto.cooperativa.SaveCooperativaDto;
import br.com.solinftec.Treinamento.dto.fazendeiro.FazendeiroWithFazendaDto;
import br.com.solinftec.Treinamento.dto.fazendeiro.SaveFazendeiroDto;
import br.com.solinftec.Treinamento.model.Cooperativa;
import br.com.solinftec.Treinamento.model.Fazendeiro;
import br.com.solinftec.Treinamento.repository.FazendeiroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FazendeiroService {

    private final FazendeiroRepository repository;


    public FazendeiroWithFazendaDto getFazendeiro(Long idFazendeiro) throws Exception {

        Optional<Fazendeiro> fazendeiro = repository.findById(idFazendeiro);

        if(fazendeiro.isPresent()) {
            return new FazendeiroWithFazendaDto(fazendeiro.get());
        } else {
            throw new Exception("FAZENDEIRO_NOT_FOUND");
        }

    }

    public SaveFazendeiroDto save(SaveFazendeiroDto saveFazendeiroDto) {
        Fazendeiro fazendeiro = saveFazendeiroDto.pegarModel();
        repository.save(fazendeiro);
        saveFazendeiroDto.setId(fazendeiro.getId());
        return saveFazendeiroDto;
    }

    public SaveFazendeiroDto update(SaveFazendeiroDto saveFazendeiroDto) throws Exception {

        Optional<Fazendeiro> fazendeiro = repository.findById(saveFazendeiroDto.getId());

        if(fazendeiro.isPresent()) {
            repository.save(saveFazendeiroDto.pegarModel());
            return saveFazendeiroDto;
        } else {
            throw new Exception("FAZENDEIRO_NOT_FOUND");
        }
    }

    public void deletar(Long idFazendeiro) throws Exception {

        Optional<Fazendeiro> fazendeiro = repository.findById(idFazendeiro);

        if(fazendeiro.isPresent()) {
            repository.delete(fazendeiro.get());
        } else {
            throw new Exception("FAZENDEIRO_NOT_FOUND");
        }
    }
}
