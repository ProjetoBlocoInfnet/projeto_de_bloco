package br.edu.infnet.academicnet.webservice;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.edu.infnet.academicnet.dao.PessoaDAO;
import br.edu.infnet.academicnet.modelo.Aluno;
import br.edu.infnet.academicnet.modelo.Pessoa;

@WebService
@Stateless
public class AlunoService {
	
	@Inject
	PessoaDAO dao;
	
	@WebMethod(operationName="todosOsAlunos")	  
	@WebResult(name="aluno")
	public List<Aluno> todosOsAlunos(){
		System.out.println("Aluno Service selecinando alunos no bd ......");		
		return dao.obterAlunos();		
	}
	
	@WebMethod(operationName="BuscarUsuariosPorNome")
	@WebResult(name="aluno")
	public List<Pessoa> UsuariosPorNome(@WebParam(name="nome") String nome){
		System.out.println("Aluno Service selecinando alunos por nome no bd ......");		
		return dao.consultarPorNomeDaPessoa(nome);		
	}
	
	
	

}
