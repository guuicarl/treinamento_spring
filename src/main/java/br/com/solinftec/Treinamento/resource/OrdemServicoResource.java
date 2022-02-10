package br.com.solinftec.Treinamento.resource;


import br.com.solinftec.Treinamento.Service.OrdemServicoService;
import br.com.solinftec.Treinamento.dto.ordemServico.SaveOrdemDto;
import br.com.solinftec.Treinamento.model.OrdemServico;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ordem")
@RequiredArgsConstructor
public class OrdemServicoResource {

    private final OrdemServicoService service;
    private static final Logger logger = LoggerFactory.getLogger(OrdemServico.class);


    @PostMapping("")
    public ResponseEntity<SaveOrdemDto> saveOrdem(@RequestBody SaveOrdemDto saveOrdemDto) {
        try {
            return ResponseEntity.ok().body(service.saveOrdem(saveOrdemDto));
        } catch (Exception e) {
            logger.error("Erro ao salvar Ordem: {}", saveOrdemDto);
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<SaveOrdemDto> updateOrdem(@RequestBody SaveOrdemDto saveOrdemDto) {
        try {
            return ResponseEntity.ok().body(service.updateOrdem(saveOrdemDto));
        } catch (Exception e) {
            logger.error("Erro ao atualizar Monitoramento: {}, error: {}", saveOrdemDto, e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{idOrdem}")
    public ResponseEntity<?> deleteOrdem(@PathVariable("idOrdem") Long idOrdem) {
        try {
            service.deletarOrdem(idOrdem);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            logger.error("Erro ao deletar Ordem: {}, error: {}", idOrdem, e.getMessage());
            if(e.getMessage().equals("ORDEM_NOT_FOUND"))
                return ResponseEntity.notFound().build();

            return ResponseEntity.badRequest().build();
        }
    }
}