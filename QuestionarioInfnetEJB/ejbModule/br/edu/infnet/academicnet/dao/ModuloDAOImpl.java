package br.edu.infnet.academicnet.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.edu.infnet.academicnet.enumerators.Status;
import br.edu.infnet.academicnet.modelo.Modulo;

@Stateless
public class ModuloDAOImpl implements ModuloDAO
{

	@PersistenceContext
	private EntityManager manager;

	@Override
	public boolean incluir(Modulo modulo)
	{
		try
		{
			modulo.setStatus(Status.ATIVO);
			manager.persist(modulo);
			manager.flush();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}	
		return true;
	}

	@Override
	public boolean alterar(Modulo modulo) {
		try
		{
			manager.merge(modulo);
			manager.flush();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean excluir(long id)
	{
		Modulo moduloBanco = manager.find(Modulo.class, id);
		try {
			moduloBanco.setStatus(Status.INATIVO);
			manager.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public Modulo obter(long id)
	{
		 TypedQuery<Modulo> query = manager.createQuery("select m from Modulo m where m.idModulo=:mId and m.status = br.edu.infnet.academicnet.enumerators.Status.ATIVO", Modulo.class);
		 query.setParameter("mId", id);
		 return query.getSingleResult();
	}

	@Override
	public List<Modulo> listar() {
		TypedQuery<Modulo> query = manager.createQuery("select m from Modulo m", Modulo.class);
		return query.getResultList();
	}

	@Override
	public List<Modulo> listarAtivos() {
		TypedQuery<Modulo> query = manager.createQuery("select m from Modulo m where status = br.edu.infnet.academicnet.enumerators.Status.ATIVO", Modulo.class);
		List<Modulo> listaModulos = query.getResultList();
		for (int i = 0; i < listaModulos.size(); i++) {
			listaModulos.get(i).getCursos();
		}
		
		return listaModulos;
	}

	
	@Override
	public List<Modulo> obterPorNome(String nome)
	{
		 TypedQuery<Modulo> query = manager.createQuery("select m from Modulo as m where m.status = br.edu.infnet.academicnet.enumerators.Status.ATIVO and m.nomeModulo like :mNome", Modulo.class);
		 query.setParameter("mNome", "%"+nome+"%");
		 return query.getResultList();
	}

}
