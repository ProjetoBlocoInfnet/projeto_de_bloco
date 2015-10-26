package br.edu.infnet.academicnet.dao;

import java.util.List;

import javax.ejb.Local;

import br.edu.infnet.academicnet.modelo.Pessoa;

@Local
public interface PessoaDAO extends GenericoDAO<Pessoa>{
	
	public List<Pessoa> consultarPorNomeDaPessoa(String nome);
	
	public List<Pessoa> listarAtivas();

}
