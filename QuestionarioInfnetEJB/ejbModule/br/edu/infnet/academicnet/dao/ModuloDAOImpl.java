package br.edu.infnet.academicnet.dao;

import java.util.List;

import javax.ejb.Stateless;

import br.edu.infnet.academicnet.modelo.Modulo;

@Stateless
public class ModuloDAOImpl implements ModuloDAO
{

	@Override
	public boolean incluir(Modulo modulo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean alterar(Modulo modulo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean excluir(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Modulo obter(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Modulo> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
