package it.cybsec.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.cybsec.model.CaseProduttrici;
import it.cybsec.model.Film;
import it.cybsec.service.CaseProduttriciService;

@RestController
@RequestMapping("/caseprod")
public class CaseProduttriciController {
	
	@Autowired
	private CaseProduttriciService caseprodservice;

	@GetMapping("/all")
	public List<CaseProduttrici> findAll(){
		return caseprodservice.findAll();
	}
	
	@GetMapping("/findid/{id}")
	public Optional<CaseProduttrici> findById(@PathVariable("id") Integer id){
		return caseprodservice.findById(id);
	}
	
	@PostMapping("/new")
	public List<CaseProduttrici> newEl(@RequestBody CaseProduttrici caseproduttrici){
		caseprodservice.newEl(caseproduttrici);
		return findAll();
	}
	
	@DeleteMapping("/delid/{id}")
	public List<CaseProduttrici> delEl(@PathVariable("id") Integer id){
		return caseprodservice.delEl(id);
	}
	
	@PutMapping("/modify/{id}")
	public List<CaseProduttrici> upDate(@PathVariable("id") Integer id,@RequestBody CaseProduttrici caseproduttrici){
		caseprodservice.upDate(id, caseproduttrici);
		return findAll();
	}
	
	@GetMapping("/listfilm/{id}")
	public List<Film> getFilm(@PathVariable("id") Integer id){
		return caseprodservice.getFilm(id);
	}
}
