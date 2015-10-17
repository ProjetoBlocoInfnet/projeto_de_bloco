package br.edu.infnet.academicnet.dao;

import java.time.LocalDate;
import java.util.List;

import br.edu.infnet.academicnet.modelo.Avaliacao;

public class AvaliacaoDAOImpl implements AvaliacaoDAO {

	@Override
	public void incluir(Avaliacao objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(Avaliacao objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Avaliacao obter(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Avaliacao> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 * @param data
	 * @return Lista de avaliacoes com a data inicio igual a do parametro enviado
	 */
	public List<Avaliacao> obterAvaliacoesPendentes(LocalDate data)
	{
		return null;
	}

	/**
	 * 
	 * @param data
	 * @return Lista de avaliacoes com a data de encerramento igual a do parametro enviado
	 */
	public List<Avaliacao> obterAvaliacoesEmDataEncerramento(LocalDate data)
	{
		return null;
	}
}
