package data;

import java.io.Serializable;

import jakarta.persistence.*;

@Table(name="numeri")
@Entity
@NamedQuery(name="getContattoByNumero",
			query="select c from Contatto c where c.numTelefoni = "
					+ "any(select n from NumTelefono n where n.numTel = :numero)")
public class NumTelefono implements Serializable{
	private Long idTelefono; 
	private String numTel;
	private Contatto contatto;
	
	public NumTelefono() {}
	
	public NumTelefono(String numTel, Contatto contatto) {
		super();
		this.numTel = numTel;
		this.contatto = contatto;
	}
	
	@Id
	@Column(name="idTelefono",nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getIdTelefono() {
		return this.idTelefono;
	}

	public void setIdTelefono(Long id) {
		this.idTelefono = id;
	}
	
	@Column(name="numTel",nullable=false,unique=true)
	public String getNumTel() {
		return numTel;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}
	
	@ManyToOne
	@JoinColumn(name="id",nullable=false)
	public Contatto getContatto() {
		return contatto;
	}

	public void setContatto(Contatto contatto) {
		this.contatto = contatto;
	}

}
