package br.edu.infnet.academicnet.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.edu.infnet.academicnet.enumerators.Status;
import br.edu.infnet.academicnet.modelo.Aluno;

@Stateless 
public class AlunoDAOImpl implements AlunoDAO{
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public boolean incluir(Aluno aluno) {
		try {			
			manager.persist(aluno);
			manager.flush();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
		
	}

	@Override
	public boolean alterar(Aluno aluno){
		
		try {
			manager.merge(aluno);
			manager.flush();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean excluir(long id) {
		Aluno alunoBanco = manager.find(Aluno.class, id);
		try {			
			alunoBanco.setStatus(Status.INATIVO);
			manager.flush();
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
	
	public List<Aluno> consultarPorTextoDaQuestao(String nome) {		
		TypedQuery<Aluno> query = manager.createQuery("select a from Aluno a where a.textoQuestao like :aNome order by a.pessoa_id", Aluno.class);
		query.setParameter("aNome", "%"+nome+"%" );
		return query.getResultList();
		 
	}
	
	public List<Aluno> listarAtivos() {		
		TypedQuery<Aluno> query = manager.createQuery("select a from Aluno a where a.status=:aAtivo order by a.pessoa_id", Aluno.class);
		query.setParameter("aAtivo", Status.ATIVO );
		return query.getResultList();		 
	}

	@Override
	public List<Aluno> listar() {
		TypedQuery<Aluno> query = manager.createQuery("select a from Aluno a", Aluno.class);
		return query.getResultList();
	}

}
