package it.cybsec.service;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.cybsec.model.Attori;
import it.cybsec.model.Film;
import it.cybsec.repository.FilmRepository;

@Service
public class FilmService {
	
	@Autowired
	private FilmRepository filmrep;
	
	public List<Film> findAll() {
		return (ArrayList<Film>) filmrep.findAll();
	}
	
	public Film findById(int id) {
		return filmrep.findById(id).get();
	}
	
	public void newEl(@Valid Film film){
		filmrep.save(film);
	}
	
	public ArrayList<Film> delEl(int id){
		filmrep.deleteById(id);
		return (ArrayList<Film>) filmrep.findAll();
	}
	
	public void upDate(Integer id, Film film) {
		film.setId(id);
		filmrep.save(film);
	}
	
	public List<Attori> getAttoriToFilm(int id) {
		List<Attori> attori = new ArrayList<Attori>();
		Film filmsfin = filmrep.findById(id).get();
		attori = filmsfin.getAttori();
		return attori;
	}

}
