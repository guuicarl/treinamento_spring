package br.com.solinftec.Treinamento.resource;

import br.com.solinftec.Treinamento.Service.CooperativaService;
import br.com.solinftec.Treinamento.Service.MonitoramentoService;
import br.com.solinftec.Treinamento.dto.cooperativa.SaveCooperativaDto;
import br.com.solinftec.Treinamento.dto.monitoramento.SaveMonitoramentoDto;
import br.com.solinftec.Treinamento.model.Cooperativa;
import br.com.solinftec.Treinamento.model.Monitoramento;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class MonitoramentoResource {
    private static final Logger logger = LoggerFactory.getLogger(Cooperativa.class);
    private final MonitoramentoService service;

    @PostMapping("")
    public ResponseEntity<SaveMonitoramentoDto> save(@RequestBody @Valid SaveMonitoramentoDto saveMonitoramentoDto) {
        try {
            return ResponseEntity.ok().body(service.save(saveMonitoramentoDto));
        } catch (Exception e) {
            logger.error("Erro ao salvar saveMonitoramento: {}", saveMonitoramentoDto);
            return ResponseEntity.badRequest().build();
        }
    }
}
