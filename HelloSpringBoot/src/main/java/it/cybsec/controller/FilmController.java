package it.cybsec.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.cybsec.model.Film;
import it.cybsec.model.Attori;
import it.cybsec.service.FilmService;

@RestController
@RequestMapping("/film")
public class FilmController {
	
	
	@Autowired
	private FilmService filmservice;

	@GetMapping("/all")
	public List<Film> findAll(){
		return filmservice.findAll();
	}
	
	@GetMapping("/findid/{id}")
	public Film findById(@PathVariable("id") Integer id){
		return filmservice.findById(id);
	}
	
	@PostMapping("/new")
	public List<Film> newEl(@RequestBody Film film){
		filmservice.newEl(film);
		return findAll();
	}
	
	@DeleteMapping("/delid/{id}")
	public List<Film> delEl(@PathVariable("id") Integer id){
		return filmservice.delEl(id);
	}
	
	@PutMapping("/modify/{id}")
	public List<Film> upDate(@PathVariable("id") Integer id,@RequestBody Film film){
		filmservice.upDate(id, film);
		return findAll();
	}
	
	@GetMapping("/attoriinfilm/{id}")
	public List<Attori> getFilmtoAttori(@PathVariable("id") Integer id){
		return filmservice.getAttoriToFilm(id);	
	}
	
}
