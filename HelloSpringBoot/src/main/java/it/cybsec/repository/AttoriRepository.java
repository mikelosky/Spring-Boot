package it.cybsec.repository;

import it.cybsec.model.Attori;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttoriRepository extends JpaRepository<Attori, Integer>{

}
