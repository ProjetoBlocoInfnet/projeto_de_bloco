package br.edu.infnet.academicnet.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.edu.infnet.academicnet.modelo.Aluno;
import br.edu.infnet.academicnet.modelo.Turma;

@Stateless
public class TurmaDAOImpl implements TurmaDAO{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public void incluir(Turma turma) {
		try {
			manager.getTransaction().begin();
			manager.persist(turma);
			manager.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
	}

	@Override
	public void alterar(Turma turma) {
		try {
			manager.getTransaction().begin();
			manager.merge(turma);
			manager.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void excluir(long id) {
		Turma turmaBanco = manager.find(Turma.class, id);

		manager.getTransaction().begin();
		manager.remove(turmaBanco);
		manager.getTransaction().commit();
		
	}

	@Override
	public Turma obter(long id) {
		 TypedQuery<Turma> query = manager.createQuery("select t from Turma t where t.idTurma=:tId ", Turma.class);
		 query.setParameter("tId", id);
		 return query.getSingleResult();
	}

	@Override
	public List<Turma> listar() {
		TypedQuery<Turma> query = manager.createQuery("select t from Turma t", Turma.class);
		return query.getResultList();
	}
	
	

}
