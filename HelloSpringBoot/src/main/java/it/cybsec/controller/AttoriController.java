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

import it.cybsec.model.Attori;
import it.cybsec.model.Film;
import it.cybsec.service.AttoriService;

@RestController
@RequestMapping("/attori")
public class AttoriController {
	
	@Autowired
	private AttoriService attservice;
	
	@GetMapping("/all")
	public List<Attori> findAll(){
		return attservice.findAll();
	}

	@GetMapping("/findid/{id}")
	public Attori findById(@PathVariable("id") Integer id){
		return attservice.findById(id);
	}
	
	@PostMapping("/new")
	public List<Attori> newEl(@RequestBody Attori attori){
		attservice.newEl(attori);
		return findAll();
	}
	
	@DeleteMapping("/delid/{id}")
	public List<Attori> delEl(@PathVariable("id") Integer id){
		return attservice.delEl(id);
	}
	
	@PutMapping("/modify/{id}")
	public List<Attori> upDate(@PathVariable("id") Integer id,@RequestBody Attori attori){
		attservice.upDate(id, attori);
		return findAll();
	}
	
	@GetMapping("/recitinfilm/{id}")
	public List<Film> getFilmtoAttori(@PathVariable("id") Integer id){
		return attservice.getFilmtoAttori(id);	
	}
	
}
