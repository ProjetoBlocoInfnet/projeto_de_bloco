package br.edu.infnet.academicnet.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.edu.infnet.academicnet.enumerators.Status;
import br.edu.infnet.academicnet.modelo.Questao;

@Stateless
public class QuestaoDAOImpl implements QuestaoDAO {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public boolean incluir(Questao questao) {
		try {			
			manager.persist(questao);	
			manager.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean alterar(Questao questao) {
		try {
			manager.merge(questao);
			manager.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean excluir(long id) {		
		Questao questaoBanco = manager.find(Questao.class, id);		
		try {
			//manager.remove(questaoBanco);
			questaoBanco.setStatus(Status.INATIVO);
			manager.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return true;
	}

	@Override
	public Questao obter(long id) {
		System.out.println("dentro obter: " + id);
		TypedQuery<Questao> query = manager.createQuery("select q from Questao q where q.idQuestao=:qId ", Questao.class);
		query.setParameter("qId", id);
		return query.getSingleResult();
	}
	
	
	public List<Questao> consultarPorTextoDaQuestao(String texto) {		
		TypedQuery<Questao> query = manager.createQuery("select q from Questao q where q.textoQuestao like :qtexto order by q.categoria", Questao.class);
		query.setParameter("qtexto", "%"+texto+"%" );
		return query.getResultList();
		 
	}
	
	public List<Questao> listarAtivas() {		
		TypedQuery<Questao> query = manager.createQuery("select q from Questao q where q.status=:qAtivo order by q.categoria", Questao.class);
		query.setParameter("qAtivo", Status.ATIVO );
		return query.getResultList();		 
	}

	@Override
	public List<Questao> listar() {
		TypedQuery<Questao> query = manager.createQuery("select q from Questao q order by q.categoria", Questao.class);
		return query.getResultList();
	}
	
}
