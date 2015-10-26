package br.edu.infnet.academicnet.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.edu.infnet.academicnet.enumerators.Status;
import br.edu.infnet.academicnet.modelo.Administrador;

public class AdministradorDAOImpl implements AdministradorDAO{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public boolean incluir(Administrador admin) {
		try {			
			manager.persist(admin);
			manager.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean alterar(Administrador admin) {
		try {
			manager.merge(admin);
			manager.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	

	@Override
	public boolean excluir(long id) {
		Administrador adminBanco = manager.find(Administrador.class, id);
		try {			
			adminBanco.setStatus(Status.INATIVO);
			manager.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public Administrador obter(long id) {
		 TypedQuery<Administrador> query = manager.createQuery("select a from Administrador a where a.pessoa_id=:pId ", Administrador.class);
		 query.setParameter("pId", id);
		 return query.getSingleResult();
	}
	
	public List<Administrador> consultarPorTextoDaQuestao(String nome) {		
		TypedQuery<Administrador> query = manager.createQuery("select a from Administrador a where a.textoQuestao like :aNome order by a.pessoa_id", Administrador.class);
		query.setParameter("aNome", "%"+nome+"%" );
		return query.getResultList();
		 
	}
	
	public List<Administrador> listarAtivos() {		
		TypedQuery<Administrador> query = manager.createQuery("select a from Administrador a where a.status=:aAtivo order by a.pessoa_id", Administrador.class);
		query.setParameter("aAtivo", Status.ATIVO );
		return query.getResultList();		 
	}

	@Override
	public List<Administrador> listar() {
		TypedQuery<Administrador> query = manager.createQuery("select a from Administrador a", Administrador.class);
		return query.getResultList();
	}

}
