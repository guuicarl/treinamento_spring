package br.com.solinftec.Treinamento.repository;


import br.com.solinftec.Treinamento.model.Cooperativa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CooperativaRepository extends JpaRepository<Cooperativa, Long> {

}