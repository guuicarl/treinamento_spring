package br.com.solinftec.Treinamento.dto.fazendeiro;

import br.com.solinftec.Treinamento.model.Fazendeiro;
import lombok.Data;

import javax.persistence.Column;

@Data
public class SaveFazendeiroDto {
    private Long id;
    private String nome;
    private String email;
    private String telefone;

    public Fazendeiro pegarModel(){
        Fazendeiro fazendeiro = new Fazendeiro();
        fazendeiro.setId(this.id);
        fazendeiro.setNome(this.nome);
        fazendeiro.setEmail(this.email);
        fazendeiro.setTelefone(this.telefone);
        return new Fazendeiro();
    }
}