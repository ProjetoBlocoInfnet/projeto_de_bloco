package br.edu.infnet.academicnet.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.edu.infnet.academicnet.modelo.AgendamentoAvaliacao;
import br.edu.infnet.academicnet.modelo.Avaliacao;

@Stateless
public class AgendamentoAvaliacaoDAOImpl implements AgendamentoAvaliacaoDAO
{
	@PersistenceContext
	private EntityManager manager;

	@Override
	public boolean incluir(AgendamentoAvaliacao agendamentoAvaliacao) {
		try
		{
			manager.persist(agendamentoAvaliacao);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}	
		return true;
	}

	@Override
	public boolean alterar(AgendamentoAvaliacao agendamentoAvaliacao) {
		try
		{
			manager.merge(agendamentoAvaliacao);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean excluir(long id) {
		AgendamentoAvaliacao agendamentoAvaliacaoBanco = manager.find(AgendamentoAvaliacao.class, id);
		manager.remove(agendamentoAvaliacaoBanco);
		return true;
	}

	@Override
	public AgendamentoAvaliacao obter(long id) {
		 TypedQuery<AgendamentoAvaliacao> query = manager.createQuery("select ag from AgendamentoAvaliacao ag where av.idAgendamento=:agId ", AgendamentoAvaliacao.class);
		 query.setParameter("agId", id);
		 return query.getSingleResult();
	}

	@Override
	public AgendamentoAvaliacao obterAtivo(long id) {
		 TypedQuery<AgendamentoAvaliacao> query = manager.createQuery("select ag from AgendamentoAvaliacao ag where ag.idAgendamento=:agId and av.status = 'Em Andamento' ", AgendamentoAvaliacao.class);
		 query.setParameter("agId", id);
		 return query.getSingleResult();
	}
	
	@Override
	public List<AgendamentoAvaliacao> listar() {
		TypedQuery<AgendamentoAvaliacao> query = manager.createQuery("select ag from AgendamentoAvaliacao ag", AgendamentoAvaliacao.class);
		return query.getResultList();
	}

}
