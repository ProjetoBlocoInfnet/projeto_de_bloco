package br.edu.infnet.academicnet.dao;

import java.util.List;

import javax.ejb.Local;

import br.edu.infnet.academicnet.modelo.Aluno;
import br.edu.infnet.academicnet.modelo.Pessoa;
import br.edu.infnet.academicnet.modelo.Professor;
import br.edu.infnet.academicnet.modelo.Usuario;

@Local
public interface PessoaDAO extends GenericoDAO<Pessoa>{
	
	public List<Pessoa> consultarPorNomeDaPessoa(String nome);
	
	public List<Pessoa> listarAtivas();
	
	public Pessoa login(String login, String senha);
	
	public Pessoa obterPorIdUsuario(Usuario usuario);

	public List<Aluno> obterAlunos();
	
	public List<Professor> obterProfessores();
	
	public Aluno obterAluno(int matricula);
	
	public Professor obterProfessor(int matricula);
}
