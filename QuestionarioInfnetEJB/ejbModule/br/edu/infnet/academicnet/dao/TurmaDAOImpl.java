package br.edu.infnet.academicnet.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.edu.infnet.academicnet.modelo.Turma;

@Stateless
public class TurmaDAOImpl implements TurmaDAO{  
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public boolean incluir(Turma turma) {
		try {
			manager.persist(turma);
			manager.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return true;
	}

	@Override
	public boolean alterar(Turma turma) {
		try {
			manager.merge(turma);
			manager.flush();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean excluir(long id) {
		Turma turmaBanco = manager.find(Turma.class, id);
		try {
			manager.remove(turmaBanco);
			manager.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public Turma obter(long id) {
		 TypedQuery<Turma> query = manager.createQuery("select t from Turma t join fetch t.alunos where t.idTurma=:tId ", Turma.class);
		 query.setParameter("tId", id);
		 return query.getSingleResult();
	}

	@Override
	public List<Turma> listar() {
		TypedQuery<Turma> query = manager.createQuery("select t from Turma t ", Turma.class);
		return query.getResultList();
	}

		

}
