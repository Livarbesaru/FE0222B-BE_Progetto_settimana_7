package business;

import java.util.List;

import data.Contatto;
import jakarta.ejb.Local;

@Local
public interface richiesteEJBLocal {
	public List<Contatto> getAllContatti();
	public void insertContatto(Contatto contatto);
	public List<Contatto> getContattoBySurname(String cognome);
	public List<Contatto> getContattoByNumero(String numero);
	public void editNumeroByContatto(String numeroPrima,String numeroDopo);
	public void eliminaContatto(Long id);
	public void modificaContatto(Contatto contatto,String nome,String cognome,String email,String numero1,String numero2);
	public Contatto getContattoById(Long id);
	public void eliminaNumero(Long id, Long idcontatto);
}
