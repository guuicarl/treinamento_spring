package br.com.solinftec.Treinamento.resource;

import br.com.solinftec.Treinamento.Service.FazendaService;
import br.com.solinftec.Treinamento.dto.cooperativa.CooperativaDto;
import br.com.solinftec.Treinamento.dto.cooperativa.SaveCooperativaDto;
import br.com.solinftec.Treinamento.dto.fazenda.FazendaDto;
import br.com.solinftec.Treinamento.dto.fazenda.GetAllFazendaDto;
import br.com.solinftec.Treinamento.dto.fazenda.SaveFazendaDto;
import br.com.solinftec.Treinamento.model.Cooperativa;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/fazenda")
@RequiredArgsConstructor
public class FazendaResource {

    private static final Logger logger = LoggerFactory.getLogger(Cooperativa.class);
    private final FazendaService service;

    @GetMapping("")
    public ResponseEntity<List<GetAllFazendaDto>> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }

    @GetMapping("/{idFazenda}")
    public ResponseEntity<FazendaDto> getFazenda(@PathVariable("idFazenda") Long idFazenda) {
        try {
            return ResponseEntity.ok().body(service.getFazenda(idFazenda));
        }  catch (Exception e) {
            if(e.getMessage().equals("FAZENDA_NOT_FOUND"))
                return ResponseEntity.notFound().build();
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("")
    public ResponseEntity<SaveFazendaDto> save(@RequestBody @Valid SaveFazendaDto saveFazendaDto) {
        try {
            return ResponseEntity.ok().body(service.save(saveFazendaDto));
        } catch (Exception e) {
            logger.error("Erro ao salvar saveFazenda: {}", saveFazendaDto);
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<SaveFazendaDto> update(@RequestBody SaveFazendaDto saveFazendaDto) {
        try {
            return ResponseEntity.ok().body(service.update(saveFazendaDto));
        } catch (Exception e) {
            logger.error("Erro ao atualizar saveFazendaDto: {}, error: {}", saveFazendaDto, e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{idFazenda}")
    public ResponseEntity<?> delete(@PathVariable("idFazenda") Long idFazenda) {
        try {
            service.deletar(idFazenda);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            logger.error("Erro ao deletar fazenda: {}, error: {}", idFazenda, e.getMessage());

            if(e.getMessage().equals("FAZENDA_NOT_FOUND"))
                return ResponseEntity.notFound().build();

            return ResponseEntity.badRequest().build();
        }
    }

}
