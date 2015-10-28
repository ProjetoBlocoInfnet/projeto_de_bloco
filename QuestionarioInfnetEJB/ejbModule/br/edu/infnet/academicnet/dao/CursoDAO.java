package br.edu.infnet.academicnet.dao;

import java.util.List;

import br.edu.infnet.academicnet.modelo.Curso;

public interface CursoDAO extends GenericoDAO<Curso>
{
	public List<Curso> obterPorNome(String nome);
}
