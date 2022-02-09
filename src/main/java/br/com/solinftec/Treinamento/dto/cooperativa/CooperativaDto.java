package br.com.solinftec.Treinamento.dto.cooperativa;

import br.com.solinftec.Treinamento.model.Cooperativa;
import lombok.Data;

@Data
public class CooperativaDto {
    private Long id;
    private String nome;
    private String email;

    public CooperativaDto(Cooperativa cooperativa){
        this.id = cooperativa.getId();
        this.nome = cooperativa.getNome();
        this.email = cooperativa.getEmail();
    }
}
