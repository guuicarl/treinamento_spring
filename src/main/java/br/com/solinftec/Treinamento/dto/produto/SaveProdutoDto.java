package br.com.solinftec.Treinamento.dto.produto;

import br.com.solinftec.Treinamento.model.Produto;
import lombok.Data;


@Data
public class SaveProdutoDto {

    private Long id;
    private String descricao;
    private Float LATITUDE;
    private Float cidade;
    private Boolean ativo;

    public Produto pegarModelPR() {
        Produto produto = new Produto();
        produto.setId(this.id);
        produto.setDescricao(this.descricao);
        produto.setLatitude(this.LATITUDE);
        produto.setId_cidade(this.cidade);
        produto.setAtivo(this.ativo);
        return produto;

    }

}