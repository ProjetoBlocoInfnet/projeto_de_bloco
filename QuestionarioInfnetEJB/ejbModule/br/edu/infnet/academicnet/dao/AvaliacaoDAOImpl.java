package br.edu.infnet.academicnet.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.edu.infnet.academicnet.modelo.Aluno;
import br.edu.infnet.academicnet.modelo.Avaliacao;

@Stateless
public class AvaliacaoDAOImpl implements AvaliacaoDAO {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public void incluir(Avaliacao avaliacao) {
		try {
			manager.getTransaction().begin();
			manager.persist(avaliacao);
			manager.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
	}

	@Override
	public void alterar(Avaliacao avaliacao) {
		try {
			manager.getTransaction().begin();
			manager.merge(avaliacao);
			manager.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void excluir(long id) {
		Avaliacao avaliacaoBanco = manager.find(Avaliacao.class, id);

		manager.getTransaction().begin();
		manager.remove(avaliacaoBanco);
		manager.getTransaction().commit();
		
	}

	@Override
	public Avaliacao obter(long id) {
		 TypedQuery<Avaliacao> query = manager.createQuery("select av from Avaliacao av where av.idAluno=:avId ", Avaliacao.class);
		 query.setParameter("avId", id);
		 return query.getSingleResult();
	}

	@Override
	public List<Avaliacao> obterPorNome(String nome)
	{
		 TypedQuery<Avaliacao> query = manager.createQuery("select a from Avaliacao as a where a.nome like :avNome ", Avaliacao.class);
		 query.setParameter("avNome", "%"+nome+"%");
		 return query.getResultList();
	}

	@Override
	public List<Avaliacao> listar() {
		TypedQuery<Avaliacao> query = manager.createQuery("select av from Avaliacao av", Avaliacao.class);
		return query.getResultList();
	}

}
