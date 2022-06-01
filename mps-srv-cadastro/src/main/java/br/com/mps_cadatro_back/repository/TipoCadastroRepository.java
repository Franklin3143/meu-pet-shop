package br.com.mps_cadatro_back.repository;

import br.com.mps_cadatro_back.model.TipoCadastro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoCadastroRepository extends JpaRepository<TipoCadastro, Long> {
}
