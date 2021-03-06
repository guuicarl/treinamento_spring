package br.com.solinftec.Treinamento.resource;

import br.com.solinftec.Treinamento.Service.TipoServicoService;
import br.com.solinftec.Treinamento.dto.tipoServico.SaveTipoServicoDto;
import br.com.solinftec.Treinamento.model.TipoServico;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tiposervico")
@RequiredArgsConstructor
public class TipoServicoResource {
    private final TipoServicoService service;
    private static final Logger logger = LoggerFactory.getLogger(TipoServico.class);

    @PostMapping("")
    public ResponseEntity<SaveTipoServicoDto> saveServico(@RequestBody SaveTipoServicoDto saveTipoServicoDto) {
        try {
            return ResponseEntity.ok().body(service.saveTServico(saveTipoServicoDto));
        } catch (Exception e) {
            logger.error("Erro ao salvar Servico: {}", saveTipoServicoDto);
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<SaveTipoServicoDto> updateServico(@RequestBody SaveTipoServicoDto saveTipoServicoDto) {
        try {
            return ResponseEntity.ok().body(service.updateTServico(saveTipoServicoDto));
        } catch (Exception e) {
            logger.error("Erro ao atualizar Servico: {}, error: {}", saveTipoServicoDto, e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{idServico}")
    public ResponseEntity<?> deleteServico(@PathVariable("idServico") Long idServico) {
        try {
            service.deletarTServico(idServico);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            logger.error("Erro ao deletar Servico: {}, error: {}", idServico, e.getMessage());
            if(e.getMessage().equals("SERVICO_NOT_FOUND"))
                return ResponseEntity.notFound().build();

            return ResponseEntity.badRequest().build();
        }
    }
}
