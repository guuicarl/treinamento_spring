package br.com.solinftec.Treinamento.repository;

import br.com.solinftec.Treinamento.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
