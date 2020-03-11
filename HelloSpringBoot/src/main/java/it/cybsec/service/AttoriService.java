package it.cybsec.service;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.cybsec.model.Attori;
import it.cybsec.model.Film;
import it.cybsec.repository.AttoriRepository;

@Service
public class AttoriService {
	
	@Autowired
	private AttoriRepository attrep;
	
	public List<Attori> findAll() {
		return (ArrayList<Attori>) attrep.findAll();
	}
	
	public Attori findById(int id) {
		return attrep.findById(id).get();
	}
	
	public void newEl(@Valid Attori attori){
		attrep.save(attori);
	}
	
	public List<Attori> delEl(int id){
		attrep.deleteById(id);
		return (List<Attori>) attrep.findAll();
	}
	
	public void upDate(Integer id, Attori attori) {
		attori.setid_Attori(id);
		attrep.save(attori);
	}
	
	public List<Film> getFilmtoAttori(int id) {
		List<Attori> attori = attrep.findAll();
		List<Film> filmsfin = new ArrayList<Film>();
		for (Attori attore : attori) {
	        if (attore.getid_Attori()==id) {
	        	filmsfin = attore.getFilm();
	        	return filmsfin;
	        }
		}
		return filmsfin;
	}
	
	
}
