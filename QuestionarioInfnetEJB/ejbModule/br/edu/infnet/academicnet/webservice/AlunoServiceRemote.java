package br.edu.infnet.academicnet.webservice;

import java.util.List;

import javax.ejb.Remote;

import br.edu.infnet.academicnet.modelo.Aluno;
import br.edu.infnet.academicnet.modelo.Pessoa;

@Remote
public interface AlunoServiceRemote
{
	public List<Aluno> todosOsAlunos();
	public List<Pessoa> UsuariosPorNome(String nome);
}
