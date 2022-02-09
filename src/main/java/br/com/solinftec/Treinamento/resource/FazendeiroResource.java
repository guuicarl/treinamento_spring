package br.com.solinftec.Treinamento.resource;

import br.com.solinftec.Treinamento.Service.FazendeiroService;
import br.com.solinftec.Treinamento.dto.fazendeiro.FazendeiroWithFazendaDto;
import br.com.solinftec.Treinamento.dto.fazendeiro.SaveFazendeiroDto;
import br.com.solinftec.Treinamento.model.Cooperativa;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/fazendeiro")
@RequiredArgsConstructor
public class FazendeiroResource {

    private static final Logger logger = LoggerFactory.getLogger(Cooperativa.class);
    private final FazendeiroService service;

    @GetMapping("/{idFazendeiro}")
    public ResponseEntity<FazendeiroWithFazendaDto> getFazendeiro(@PathVariable("idFazendeiro") Long idFazendeiro) {
        try {
            return ResponseEntity.ok().body(service.getFazendeiro(idFazendeiro));
        } catch (Exception e) {
            if(e.getMessage().equals("FAZENDEIRO_NOT_FOUND"))
                return ResponseEntity.notFound().build();
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("")
    public ResponseEntity<SaveFazendeiroDto> save(@RequestBody @Valid SaveFazendeiroDto saveFazendeiroDto) {
        try {
            return ResponseEntity.ok().body(service.save(saveFazendeiroDto));
        } catch (Exception e) {
            logger.error("Erro ao salvar saveFazendeiroDto: {}", saveFazendeiroDto);
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<SaveFazendeiroDto> update(@RequestBody SaveFazendeiroDto saveFazendeiroDto) {
        try {
            return ResponseEntity.ok().body(service.update(saveFazendeiroDto));
        } catch (Exception e) {
            logger.error("Erro ao atualizar saveFazendeiro: {}, error: {}", saveFazendeiroDto, e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{idFazendeiro}")
    public ResponseEntity<?> delete(@PathVariable("idFazendeiro") Long idFazendeiro) {
        try {
            service.deletar(idFazendeiro);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            logger.error("Erro ao deletar cooperativa: {}, error: {}", idFazendeiro, e.getMessage());

            if(e.getMessage().equals("FAZENDEIRO_NOT_FOUND"))
                return ResponseEntity.notFound().build();

            return ResponseEntity.badRequest().build();
        }
    }
}
