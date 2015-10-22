package br.edu.infnet.academicnet.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.edu.infnet.academicnet.modelo.Aluno;

@Stateless 
public class AlunoDAOImpl implements AlunoDAO{
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public boolean incluir(Aluno aluno) {
		try {
			manager.getTransaction().begin();
			manager.persist(aluno);
			manager.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
		
	}

	@Override
	public boolean alterar(Aluno aluno) {
		
		try {
			manager.getTransaction().begin();
			manager.merge(aluno);
			manager.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean excluir(long id) {
		Aluno alunoBanco = manager.find(Aluno.class, id);
		try {
			manager.getTransaction().begin();
			manager.remove(alunoBanco);
			manager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public Aluno obter(long id) {
		 TypedQuery<Aluno> query = manager.createQuery("select a from Aluno a where a.idAluno=:pId ", Aluno.class);
		 query.setParameter("pId", id);
		 return query.getSingleResult();
	}

	@Override
	public List<Aluno> listar() {
		TypedQuery<Aluno> query = manager.createQuery("select a from Aluno a", Aluno.class);
		return query.getResultList();
	}

}
