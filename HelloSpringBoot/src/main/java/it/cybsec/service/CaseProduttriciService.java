package it.cybsec.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.cybsec.model.CaseProduttrici;
import it.cybsec.model.Film;
import it.cybsec.repository.CaseProduttriciRepository;

@Service
public class CaseProduttriciService {
	
	@Autowired
	private CaseProduttriciRepository casprrep;

	@Autowired
	private FilmService filmservice;
	
	public ArrayList<CaseProduttrici> findAll() {
		return (ArrayList<CaseProduttrici>) casprrep.findAll();
	}
	
	public Optional<CaseProduttrici> findById(int id) {
		return (Optional<CaseProduttrici>) casprrep.findById(id);
	}
	
	public void newEl(@Valid CaseProduttrici caseProduttrici){
		casprrep.save(caseProduttrici);
	}
	
	public ArrayList<CaseProduttrici> delEl(int id){
		casprrep.deleteById(id);
		return (ArrayList<CaseProduttrici>) casprrep.findAll();
	}
	
	public void upDate(Integer id, CaseProduttrici caseProduttrici) {
		caseProduttrici.setid_Cas_Prod(id);
		casprrep.save(caseProduttrici);
	}
	
	public List<Film> getFilm(int id){
		CaseProduttrici casaprd;
		List<Film> filmsfin = new ArrayList<Film>();
		List<Film> films = filmservice.findAll();
		for (Film film : films) {
			casaprd = film.getcase_Produttrici();
	        if (casaprd.getid_Cas_Prod()==id) {
	        	filmsfin.add(film);
	        }
		}
		return filmsfin;
	}
}
