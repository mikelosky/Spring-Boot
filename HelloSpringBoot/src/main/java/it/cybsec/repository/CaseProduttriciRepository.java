package it.cybsec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.cybsec.model.CaseProduttrici;

@Repository
public interface CaseProduttriciRepository extends JpaRepository<CaseProduttrici, Integer>{

}
