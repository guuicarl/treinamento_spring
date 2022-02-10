package br.com.solinftec.Treinamento.dto.produto;

import br.com.solinftec.Treinamento.model.Produto;
import lombok.Data;

@Data
public class ProdutoDto {

    private Long id;
    private String descricao;
    private Float LATITUDE;
    private Float cidade;
    private Boolean ativo;

    public ProdutoDto(Produto produto) {
        this.id = produto.getId();
        this.descricao = produto.getDescricao();
        this.cidade = produto.getId_cidade();
        this.ativo = produto.getAtivo();
    }
}