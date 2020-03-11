package it.cybsec.model;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="casa_produttrice")
@JsonIgnoreProperties({"film"})
public class CaseProduttrici implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private int id_cas_prod;
	@Column(name = "nome")
	private String nome;
	@Column(name = "anno_fondazione")
	private int fondazione;
	@Column(name = "sede_principale")
	private String sede_prin;
	@Column(name = "img")
	private String img;
	
	public int getid_Cas_Prod() {
		return id_cas_prod;
	}
	
	public void setid_Cas_Prod(int id_cas_prod) {
		this.id_cas_prod = id_cas_prod;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getFondazione() {
		return fondazione;
	}
	
	public void setFondazione(int fondazione) {
		this.fondazione = fondazione;
	}
	
	public String getSede() {
		return sede_prin;
	}
	
	public void setSede(String sede_prin) {
		this.sede_prin = sede_prin;
	}
	
	public String getImg() {
		return img;
	}
	
	public void setImg(String img) {
		this.img = img;
	}
	
	@OneToMany(mappedBy = "case_produttrici", fetch = FetchType.EAGER)
	
	private List<Film> film; 
	
	public List<Film> getFilm() {
		return film;
	}

	public void setFilm(List<Film> film) {
		this.film = film;
	}

}
