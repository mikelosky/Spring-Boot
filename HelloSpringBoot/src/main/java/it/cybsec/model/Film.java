package it.cybsec.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="film")
@JsonIgnoreProperties({"case_produttrici","attori"})
public class Film implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_film")
	private int id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "anno_uscita")
	private int anno_uscita;
	
	@Column(name = "incassi")
	private int incassi;
	
	@Column(name = "img")
	private String img;
	
	@ManyToOne
	@JoinColumn(name = "id_casa_prod")
	
	private CaseProduttrici case_produttrici;
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "perfomano", 
        joinColumns = { @JoinColumn(name = "id_film") }, 
        inverseJoinColumns = { @JoinColumn(name = "id_attori") }
    )
    private List<Attori> attori;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getanno_Uscita() {
		return anno_uscita;
	}

	public void setanno_Uscita(int anno_uscita) {
		this.anno_uscita = anno_uscita;
	}
	
	public int getIncassi() {
		return incassi;
	}

	public void setIncassi(int incassi) {
		this.incassi = incassi;
	}
	
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	
	public CaseProduttrici getcase_Produttrici() {
		return case_produttrici;
	}

	public void setcase_Produttrici(CaseProduttrici case_produttrici) {
		this.case_produttrici = case_produttrici;
	}
	
	public List<Attori> getAttori(){
		return this.attori;
	}
	
	public void setAttori (List<Attori> attori) {
		this.attori = attori;
	}
}
