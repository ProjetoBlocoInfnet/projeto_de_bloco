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
		TypedQuery<Curso> query = manager.createQuery("select c from Curso c join fetch c.turmas where c.status = br.edu.infnet.academicnet.enumerators.Status.ATIVO and c.idCurso=:cId ", Curso.class);
		query.setParameter("cId", id);
		Curso c = query.getSingleResult();
		
		TypedQuery<Curso> query2 = manager.createQuery("select c from Curso c join fetch c.modulo where c.status = br.edu.infnet.academicnet.enumerators.Status.ATIVO and c.idCurso=:cId ", Curso.class);
		query2.setParameter("cId", id);
		Curso c2 = query2.getSingleResult();
		c.setModulo(c2.getModulo());
		
		//System.out.println("Quantidade de Módulos retornados = "+ c.getModulo().size());
		//System.out.println("Quantidade de Turmas retornados = "+ c.getTurmas().size());
		return c;
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
		 TypedQuery<Curso> query = manager.createQuery("select c from Curso as c where c.status = br.edu.infnet.academicnet.enumerators.Status.ATIVO and c.nome like :mNome", Curso.class);
		 query.setParameter("mNome", "%"+nome+"%");
		 return query.getResultList();
	}
	
	/* Eu criei essas duas Queries par atentar fazer a busca dos módulos mas está dando erros */
	
	@Override
	public List<Modulo> listarModulosPorCursoId(Long idCurso) {		
		System.out.println("buscando o curso...");
		System.out.println("idCurso "+ idCurso);
		System.out.println();
		TypedQuery<Modulo> query = manager.createQuery("select m from Modulo m inner join m.cursos cur where cur.idCurso=:cId",Modulo.class);		
		query.setParameter("cId", idCurso);
		List<Modulo> modulos = query.getResultList();				
		return modulos;
	}
	
	@Override
	public Curso CursoComModulosCursoId(Long idCurso){	
		System.out.println("buscando o curso...");
		System.out.println("idCurso "+ idCurso);
		System.out.println();
		//TypedQuery<Curso> query = manager.createQuery("select c from Curso c INNER JOIN FETCH c.modulo m where c.idCurso=:cId",Curso.class);
		//query.setParameter("cId", idCurso);
		TypedQuery<Curso> query = manager.createQuery("select c from Curso c  where c.idCurso=:cId", Curso.class);
		query.setParameter("cId", idCurso);
		try {
			Curso curso = query.getSingleResult();	
			return curso;
		} catch (Exception e) {
			return null;
		}
		
	}

	@Override
	public List<Curso> listarAtivos()
	{
		TypedQuery<Curso> query = manager.createQuery("select c from Curso c  where c.status = br.edu.infnet.academicnet.enumerators.Status.ATIVO", Curso.class);
		return query.getResultList();
	}



	

}
