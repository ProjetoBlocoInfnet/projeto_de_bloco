package br.edu.infnet.academicnet.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.edu.infnet.academicnet.modelo.Perfil;

@Stateless
public class PerfilDAOImpl implements PerfilDAO{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public boolean incluir(Perfil objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean alterar(Perfil objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean excluir(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Perfil obter(long id) {		
		 TypedQuery<Perfil> query = manager.createQuery("select p from Perfil p where p.idPerfil=:pId ", Perfil.class);
		 query.setParameter("pId", id);
		 return query.getSingleResult();
	}

	@Override
	public List<Perfil> listar() {
		TypedQuery<Perfil> query = manager.createQuery("select p from Perfil p", Perfil.class);
		return query.getResultList();
	}
	
	

}
