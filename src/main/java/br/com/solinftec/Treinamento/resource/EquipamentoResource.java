package br.com.solinftec.Treinamento.resource;

import br.com.solinftec.Treinamento.Service.EquipamentoService;
import br.com.solinftec.Treinamento.dto.equipamento.EquipamentoDto;
import br.com.solinftec.Treinamento.dto.equipamento.SaveEquipamentoDto;
import br.com.solinftec.Treinamento.model.Equipamento;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipamento")
@RequiredArgsConstructor
public class EquipamentoResource {

    private final EquipamentoService service;
    private static final Logger logger = LoggerFactory.getLogger(Equipamento.class);


    @GetMapping("")
    public ResponseEntity<List<EquipamentoDto>> getAllEquipamentos() {
        return ResponseEntity.ok().body(service.getAllEquipamentos());
    }

    @PostMapping("")
    public ResponseEntity<SaveEquipamentoDto> saveEquipamento(@RequestBody SaveEquipamentoDto saveEquipamentoDto) {
        try {
            return ResponseEntity.ok().body(service.saveEquipamento(saveEquipamentoDto));
        } catch (Exception e) {
            logger.error("Erro ao salvar Equipamento: {}", saveEquipamentoDto);
            return ResponseEntity.badRequest().build();
        }
    }


    @DeleteMapping("/{idEquipamento}")
    public ResponseEntity<?> delete(@PathVariable("idEquipamento") Long idEquipamento) {
        try {
            service.deletarEquipamento(idEquipamento);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            logger.error("Erro ao deletar Equipamento: {}, error: {}", idEquipamento, e.getMessage());
            if(e.getMessage().equals("Equipamento_NOT_FOUND"))
                return ResponseEntity.notFound().build();
            return ResponseEntity.badRequest().build();
        }
    }


}