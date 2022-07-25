package business;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import data.Contatto;
import data.NumTelefono;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

@Stateless
@LocalBean
public class richiesteEJB implements richiesteEJBLocal {
	@PersistenceContext(unitName="progSett7Persistence")
	EntityManager em;

    public richiesteEJB() {
    }

	@Override
	public List<Contatto> getAllContatti() {
		Query query=em.createNamedQuery("getAllContatti");
		List<Contatto> cont=query.getResultList();
		return cont;
	}

	@Override
	public void insertContatto(Contatto contatto) {
		em.persist(contatto);
	}

	@Override
	public List<Contatto> getContattoBySurname(String cognome) {
		Query query=em.createNamedQuery("getContattoBySurname");
		query.setParameter("cognome", cognome);
		List<Contatto> cont=query.getResultList();
		return cont;
	}

	@Override
	public List<Contatto> getContattoByNumero(String numero) {
		Query query=em.createNamedQuery("getContattoByNumero");
		query.setParameter("numero", numero);
		List<Contatto> cont=(List<Contatto>) query.getResultList();
		return cont;
	}

	@Override
	public void editNumeroByContatto(String numeroPrima,String numeroDopo) {
		Contatto c=getContattoByNumero(numeroPrima).get(0);
		if(c!=null) {
			c=em.find(Contatto.class, c.getId());
			List<NumTelefono> num=c.getNumTelefoni();
			for(NumTelefono n:num) {
				if(n.getNumTel().equals(numeroPrima)) {
					n.setNumTel(numeroDopo);
				}
			}
			c.setNumTelefoni(num);
			em.merge(c);
		}
	}
	

	@Override
	public void eliminaContatto(Long id) {
		em.remove(em.find(Contatto.class, id));
	}

	@Override
	public void modificaContatto(Contatto contatto,String nome,String cognome,String email,String numero1,String numero2) {
		Contatto con=em.find(Contatto.class, contatto.getId());
		con.setNome(nome);
		con.setCognome(cognome);
		con.setEmail(email);
		if(con.getNumTelefoni().size()>0) {
			for(NumTelefono n:con.getNumTelefoni()) {
				if(con.getNumTelefoni().indexOf(n)==0) {
					con.getNumTelefoni().get(0).setNumTel(numero1);
				}
				if(numero2!=null &&
						//Daniele Liburdi
					numero2.replaceAll(" ", "")!="" &&
					con.getNumTelefoni().size()>1 &&
					con.getNumTelefoni().indexOf(n)>0) {
					con.getNumTelefoni().get(1).setNumTel(numero2);
				}
			}
			if(numero2!=null &&
					numero2.replaceAll(" ", "")!="" &&
					con.getNumTelefoni().size()==1) {
				con.getNumTelefoni().add(new NumTelefono(numero2,con));
			}
		}
		else {
			con.getNumTelefoni().add(new NumTelefono(numero1,con));
			if(numero2!=null &&
					numero2.replaceAll(" ", "")!="") {
					con.getNumTelefoni().add(new NumTelefono(numero2,con));
			}
		}
		em.merge(con);
	}

	@Override
	public Contatto getContattoById(Long id) {
		return em.find(Contatto.class, id);
	}

	@Override
	public void eliminaNumero(Long id, Long idcontatto) {
		Contatto c=em.find(Contatto.class, idcontatto);
		int index=c.getNumTelefoni().indexOf(em.find(NumTelefono.class, id));
		c.getNumTelefoni().remove(index);
		em.remove(em.find(NumTelefono.class, id));
	}

}
