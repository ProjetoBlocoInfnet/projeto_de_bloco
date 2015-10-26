package br.edu.infnet.academicnet.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.edu.infnet.academicnet.enumerators.Status;
import br.edu.infnet.academicnet.modelo.Pessoa;

@Stateless
public class PessoaDAOImpl implements PessoaDAO{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public boolean incluir(Pessoa objeto) {
		try {			
			manager.persist(objeto);	
			manager.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean alterar(Pessoa objeto) {
		try {
			manager.merge(objeto);
			manager.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean excluir(long id) {
		Pessoa pessoaBanco = manager.find(Pessoa.class, id);		
		try {
			//manager.remove(PessoaBanco);
			pessoaBanco.setStatus(Status.INATIVO);
			manager.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return true;
	}

	@Override
	public Pessoa obter(long id) {		
		TypedQuery<Pessoa> query = manager.createQuery("select p from Pessoa p where p.matricula=:pId ", Pessoa.class);
		query.setParameter("pId", id);
		return query.getSingleResult();
	}
	
	
	public List<Pessoa> consultarPorNomeDaPessoa(String nome) {		
		TypedQuery<Pessoa> query = manager.createQuery("select p from Pessoa p where p.nome like :pNome order by p.matricula", Pessoa.class);
		query.setParameter("pNome", "%"+nome+"%" );
		return query.getResultList();
		 
	}
	
	public List<Pessoa> listarAtivas() {		
		TypedQuery<Pessoa> query = manager.createQuery("select p from Pessoa p where p.status=:pAtivo order by p.matricula", Pessoa.class);
		query.setParameter("pAtivo", Status.ATIVO );
		return query.getResultList();		 
	}

	@Override
	public List<Pessoa> listar() {
		TypedQuery<Pessoa> query = manager.createQuery("select p from Pessoa p order by p.matricula", Pessoa.class);
		return query.getResultList();
	}
	

}
