package br.edu.infnet.academicnet.dao;

import java.util.List;

import javax.ejb.Remote;
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
	public void incluir(Aluno aluno) {
		try {
			manager.getTransaction().begin();
			manager.persist(aluno);
			manager.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
	}

	@Override
	public void alterar(Aluno aluno) {
		
		try {
			manager.getTransaction().begin();
			manager.merge(aluno);
			manager.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void excluir(long id) {
		Aluno alunoBanco = manager.find(Aluno.class, id);

		manager.getTransaction().begin();
		manager.remove(alunoBanco);
		manager.getTransaction().commit();
		
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
