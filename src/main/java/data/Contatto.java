package data;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;

@Table(name="contatti")
@Entity
@NamedQuery(name="getAllContatti",query="Select c from Contatto c")
@NamedQuery(name="getContattoBySurname",query="Select c from Contatto c where c.cognome = :cognome")
public class Contatto implements Serializable{
	private Long id;
	private String nome;
	private String cognome;
	private String email;
	private List<NumTelefono> numTelefoni;
	
	public Contatto() {}
	
	public Contatto(String nome, String cognome, String email) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
	}
	@Id
	@Column(name="id",nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="nome",nullable=false)
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Column(name="cognome",nullable=false)
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	@Column(name="email",nullable=false)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@OneToMany(mappedBy="contatto",cascade=CascadeType.ALL)
	//Daniele Liburdi
	public List<NumTelefono> getNumTelefoni() {
		return numTelefoni;
	}
	public void setNumTelefoni(List<NumTelefono> numTelefoni) {
		this.numTelefoni = numTelefoni;
	}
	
}
