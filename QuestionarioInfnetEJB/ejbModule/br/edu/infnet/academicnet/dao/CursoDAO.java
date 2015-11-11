package br.edu.infnet.academicnet.dao;

import java.util.List;

import br.edu.infnet.academicnet.modelo.Curso;
import br.edu.infnet.academicnet.modelo.Modulo;

public interface CursoDAO extends GenericoDAO<Curso>
{
	public List<Curso> obterPorNome(String nome);

	public List<Modulo> listarModulosPorCursoId(Long idCurso);
	
	public Curso CursoComModulosCursoId(Long idCurso);
	
	
	public List<Curso> listarAtivos();
}
