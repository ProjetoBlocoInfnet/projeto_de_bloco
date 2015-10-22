package br.edu.infnet.academicnet.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.edu.infnet.academicnet.modelo.ResultadoAvaliacao;

@Stateless
public class ResultadoAvaliacaoDAOImpl implements ResultadoAvaliacaoDAO {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public boolean incluir(ResultadoAvaliacao resultAvaliacao) {
		try {
			manager.getTransaction().begin();
			manager.persist(resultAvaliacao);
			manager.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean alterar(ResultadoAvaliacao resultAvaliacao) {
		try {
			manager.getTransaction().begin();
			manager.merge(resultAvaliacao);
			manager.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean excluir(long id) {
		ResultadoAvaliacao ResultadoAvaliacaoBanco = manager.find(ResultadoAvaliacao.class, id);
		try {
			manager.getTransaction().begin();
			manager.remove(ResultadoAvaliacaoBanco);
			manager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public ResultadoAvaliacao obter(long id) {
		TypedQuery<ResultadoAvaliacao> query = manager.createQuery("select r from ResultadoAvaliacao r where r.idResultadoAvaliacao=:rId ", ResultadoAvaliacao.class);
		 query.setParameter("rId", id);
		 return query.getSingleResult();
	}

	@Override
	public List<ResultadoAvaliacao> listar() {
		TypedQuery<ResultadoAvaliacao> query = manager.createQuery("select r from ResultadoAvaliacao r", ResultadoAvaliacao.class);
		return query.getResultList();
	}

}
