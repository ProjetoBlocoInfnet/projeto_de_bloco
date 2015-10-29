package br.edu.infnet.academicnet.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.edu.infnet.academicnet.enumerators.Status;
import br.edu.infnet.academicnet.modelo.Curso;
import br.edu.infnet.academicnet.modelo.Modulo;

@Stateless
public class CursoDAOImpl implements CursoDAO
{
	@PersistenceContext
	private EntityManager manager;

	@Override
	public boolean incluir(Curso curso)
	{
		try
		{
			curso.setStatus(Status.ATIVO);
			manager.persist(curso);
			manager.flush();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean alterar(Curso curso)
	{
		try
		{
			manager.merge(curso);
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
		Curso cursoBanco = manager.find(Curso.class, id);
		try
		{
			cursoBanco.setStatus(Status.INATIVO);
			manager.flush();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public Curso obter(long id)
	{
		TypedQuery<Curso> query = manager.createQuery("select c from Curso c where c.idCurso=:cId and status = br.edu.infnet.academicnet.enumerators.Status.ATIVO", Curso.class);
		query.setParameter("cId", id);
		return query.getSingleResult();
	}

	@Override
	public List<Curso> listar()
	{
		TypedQuery<Curso> query = manager.createQuery("select c from Curso c", Curso.class);
		return query.getResultList();
	}
	
	@Override
	public List<Curso> obterPorNome(String nome)
	{
		 TypedQuery<Curso> query = manager.createQuery("select c from Curso as c where c.status = br.edu.infnet.academicnet.enumerators.Status.ATIVO and c.nomeModulo like :mNome", Curso.class);
		 query.setParameter("mNome", "%"+nome+"%");
		 return query.getResultList();
	}
	
	/* Eu criei essas duas Queries par atentar fazer a busca dos módulos mas está dando erros */
	
	@Override
	public List<Modulo> listarModulosPorCursoId(Long idCurso) {		
		TypedQuery<Modulo> query = manager.createQuery("select m from Modulo m inner join m.curso c",Modulo.class);
		List<Modulo> modulos = query.getResultList();				
		return modulos;
	}
	
	@Override
	public Curso CursoComModulosCursoId(Long idCurso){		
		TypedQuery<Curso> query = manager.createQuery("select c from Curso c join fetch c.modulo m where c.idCurso =:cId",Curso.class);
		query.setParameter("cId", idCurso);
		Curso curso = query.getSingleResult();				
		return curso;
	}



	

}
