package br.edu.infnet.academicnet.dao;

import java.sql.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.edu.infnet.academicnet.enumerators.StatusAvaliacao;
import br.edu.infnet.academicnet.modelo.AgendamentoAvaliacao;

@Stateless
public class AgendamentoAvaliacaoDAOImpl implements AgendamentoAvaliacaoDAO
{
	@PersistenceContext
	private EntityManager manager;

	@Override
	public boolean incluir(AgendamentoAvaliacao agendamentoAvaliacao) {
		try
		{
			agendamentoAvaliacao.setStatus(StatusAvaliacao.CRIADO);
			manager.persist(agendamentoAvaliacao);
			manager.flush();
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
	public boolean excluir(long id)
	{
		AgendamentoAvaliacao agendamentoBanco = manager.find(AgendamentoAvaliacao.class, id);
		try
		{
			agendamentoBanco.setStatus(StatusAvaliacao.INATIVO);
			manager.flush();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public AgendamentoAvaliacao obter(long id) {
		 TypedQuery<AgendamentoAvaliacao> query = manager.createQuery("select ag from AgendamentoAvaliacao ag where ag.idAgendamento=:agId and not ag.status = br.edu.infnet.academicnet.enumerators.StatusAvaliacao.INATIVO  ", AgendamentoAvaliacao.class);
		 query.setParameter("agId", id);
		 return query.getSingleResult();
	}

	@Override
	public AgendamentoAvaliacao obterAtivo(long id) {
		 TypedQuery<AgendamentoAvaliacao> query = manager.createQuery("select ag from AgendamentoAvaliacao ag where ag.idAgendamento=:agId and ag.status = br.edu.infnet.academicnet.enumerators.StatusAvaliacao.EM_ANDAMENTO ", AgendamentoAvaliacao.class);
		 query.setParameter("agId", id);
		 return query.getSingleResult();
	}
	
	@Override
	public List<AgendamentoAvaliacao> listar() {
		TypedQuery<AgendamentoAvaliacao> query = manager.createQuery("select ag from AgendamentoAvaliacao ag", AgendamentoAvaliacao.class);
		return query.getResultList();
	}

	@Override
	public List<AgendamentoAvaliacao> obterPorStatusDataInicio(StatusAvaliacao status,
			Date data) {
		 TypedQuery<AgendamentoAvaliacao> query = manager.createQuery("select ag from AgendamentoAvaliacao ag where ag.dataInicio=:agData and ag.status =:agStatus ", AgendamentoAvaliacao.class);
		 query.setParameter("agStatus", status);
		 query.setParameter("agData", data);
		 return query.getResultList();
	}

	@Override
	public List<AgendamentoAvaliacao> obterPorStatusDataFim(StatusAvaliacao status,
			Date data) {
		 TypedQuery<AgendamentoAvaliacao> query = manager.createQuery("select ag from AgendamentoAvaliacao ag where ag.dataFim=:agData and av.status =:agStatus ", AgendamentoAvaliacao.class);
		 query.setParameter("agStatus", status);
		 query.setParameter("agData", data);
		 return query.getResultList();
	}

	@Override
	public List<AgendamentoAvaliacao> obterPorDataInicio(
			Date data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AgendamentoAvaliacao> obterPorDataFim(
			Date data) {
		// TODO Auto-generated method stub
		return null;
	}

}
