package br.edu.infnet.academicnet.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.edu.infnet.academicnet.enumerators.Status;
import br.edu.infnet.academicnet.modelo.Avaliacao;
import br.edu.infnet.academicnet.modelo.Questao;

@Stateless
public class AvaliacaoDAOImpl implements AvaliacaoDAO {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public boolean incluir(Avaliacao avaliacao) {
		try
		{
			manager.persist(avaliacao);
			manager.flush();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}	
		return true;
	}

	@Override
	public boolean alterar(Avaliacao avaliacao) {
		try
		{
			manager.merge(avaliacao);
			manager.flush();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean excluir(long id) {
		Avaliacao avaliacaoBanco = manager.find(Avaliacao.class, id);		
		try {
			avaliacaoBanco.setStatus(Status.INATIVO);
			manager.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public boolean excluirQuestao(long idAvaliacao, long idQuestao){
		
		Avaliacao avaliacaoBanco = manager.find(Avaliacao.class, idAvaliacao);
		Questao questaoBanco = manager.find(Questao.class, idQuestao);	
				
		try {
			avaliacaoBanco.getListQuestao().remove(questaoBanco);
			manager.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	

	@Override
	public Avaliacao obter(long id) {
		 TypedQuery<Avaliacao> query = manager.createQuery("select av from Avaliacao av where av.idAvaliacao=:avId ", Avaliacao.class);
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
