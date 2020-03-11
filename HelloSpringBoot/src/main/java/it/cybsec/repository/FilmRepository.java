package it.cybsec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.cybsec.model.Film;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer> {

}
