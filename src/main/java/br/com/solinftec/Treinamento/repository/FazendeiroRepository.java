package br.com.solinftec.Treinamento.repository;

import br.com.solinftec.Treinamento.model.Fazendeiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FazendeiroRepository extends JpaRepository<Fazendeiro, Long> {

}
