package br.edu.infnet.academicnet.dao;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.edu.infnet.academicnet.enumerators.StatusAvaliacao;
import br.edu.infnet.academicnet.modelo.AgendamentoAvaliacao;

@Stateless
public class AgendamentoAvaliacaoDAOImpl implements AgendamentoAvaliacaoDAO
{
	//@PersistenceContext(type = PersistenceContextType.EXTENDED)
	@PersistenceContext
	private EntityManager manager;

	@Override
	public boolean incluir(AgendamentoAvaliacao agendamentoAvaliacao) {
		try
		{
			if(agendamentoAvaliacao.getDataInicio().equals(Date.valueOf(LocalDate.now())))
			{
				agendamentoAvaliacao.setStatus(StatusAvaliacao.EM_ANDAMENTO);
			}
			else
			{
				agendamentoAvaliacao.setStatus(StatusAvaliacao.CRIADO);
			}
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
		try
		{
			return query.getSingleResult();
		}
		catch (NoResultException e)
		{
			return null;
		}
	}

	@Override
	public AgendamentoAvaliacao obterAtivo(long id) {
		TypedQuery<AgendamentoAvaliacao> query = manager.createQuery("select ag from AgendamentoAvaliacao ag where ag.idAgendamento=:agId and ag.status = br.edu.infnet.academicnet.enumerators.StatusAvaliacao.EM_ANDAMENTO ", AgendamentoAvaliacao.class);
		query.setParameter("agId", id);
		try
		{
			return query.getSingleResult();
		}
		catch (NoResultException e)
		{
			return null;
		}
	}
	
	@Override
	public List<AgendamentoAvaliacao> listar() {
		TypedQuery<AgendamentoAvaliacao> query = manager.createQuery("select ag from AgendamentoAvaliacao ag", AgendamentoAvaliacao.class);
		return query.getResultList();
	}

	@Override
	public List<AgendamentoAvaliacao> obterPorStatusDataInicio(StatusAvaliacao status,
			Date data) {
		System.out.println("Dentro da função de sql");
		System.out.println(data);
		System.out.println(status);
		manager = Persistence.createEntityManagerFactory("academicnetDS").createEntityManager();
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
		 TypedQuery<AgendamentoAvaliacao> query = manager.createQuery("select ag from AgendamentoAvaliacao ag where ag.dataInicio=:agData", AgendamentoAvaliacao.class);
		 query.setParameter("agData", data);
		 return query.getResultList();
	}

	@Override
	public List<AgendamentoAvaliacao> obterPorDataFim(
			Date data) {
		 TypedQuery<AgendamentoAvaliacao> query = manager.createQuery("select ag from AgendamentoAvaliacao ag where ag.dataFim=:agData", AgendamentoAvaliacao.class);
		 query.setParameter("agData", data);
		 return query.getResultList();	}

	@Override
	public List<AgendamentoAvaliacao> obterPorNomeAvaliacao(String nome)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
