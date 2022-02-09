package br.com.solinftec.Treinamento.repository;

import br.com.solinftec.Treinamento.model.Fazenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FazendaRepository extends JpaRepository<Fazenda, Long> {

}
