package br.com.solinftec.Treinamento.repository;

import br.com.solinftec.Treinamento.model.Equipamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipamentoRepository  extends JpaRepository<Equipamento, Long> {
}
