package br.edu.infnet.academicnet.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.edu.infnet.academicnet.modelo.Questao;

@Stateless
public class QuestaoDAOImpl implements QuestaoDAO {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public void incluir(Questao questao) {
		try {
			manager.getTransaction().begin();
			manager.persist(questao);
			manager.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void alterar(Questao questao) {
		try {
			manager.getTransaction().begin();
			manager.merge(questao);
			manager.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void excluir(long id) {
		Questao questaoBanco = manager.find(Questao.class, id);

		manager.getTransaction().begin();
		manager.remove(questaoBanco);
		manager.getTransaction().commit();
		
	}

	@Override
	public Questao obter(long id) {
		TypedQuery<Questao> query = manager.createQuery("select q from Questao q where q.idQuestao=:qId ", Questao.class);
		 query.setParameter("pId", id);
		 return query.getSingleResult();
	}

	@Override
	public List<Questao> listar() {
		TypedQuery<Questao> query = manager.createQuery("select q from Questao q", Questao.class);
		return query.getResultList();
	}
	
}
