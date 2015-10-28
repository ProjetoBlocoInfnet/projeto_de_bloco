package br.edu.infnet.academicnet.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.edu.infnet.academicnet.enumerators.Status;
import br.edu.infnet.academicnet.modelo.Aluno;
import br.edu.infnet.academicnet.modelo.Pessoa;
import br.edu.infnet.academicnet.modelo.Professor;
import br.edu.infnet.academicnet.modelo.Usuario;


@Stateless
public class PessoaDAOImpl implements PessoaDAO{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public boolean incluir(Pessoa objeto) {
		try {			
			manager.persist(objeto);	
			manager.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean alterar(Pessoa objeto) {
		try {			
			manager.merge(objeto);
			manager.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean excluir(long id) {
		Pessoa pessoaBanco = manager.find(Pessoa.class, id);		
		try {
			//manager.remove(PessoaBanco);
			pessoaBanco.setStatus(Status.INATIVO);
			manager.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	

	@Override
	public Pessoa obter(long id) {		
		TypedQuery<Pessoa> query = manager.createQuery("select p from Pessoa p where p.matricula=:pId ", Pessoa.class);
		query.setParameter("pId", id);
		return query.getSingleResult();
	}
	
	@Override
	public Pessoa obterPorIdUsuario(Usuario usuario) {		
		TypedQuery<Pessoa> query = manager.createQuery("select p from Pessoa p where p.usuario=:uId ", Pessoa.class);
		query.setParameter("uId", usuario);
		return query.getSingleResult();
	}
	
	@Override
	public List<Pessoa> consultarPorNomeDaPessoa(String nome) {		
		TypedQuery<Pessoa> query = manager.createQuery("select p from Pessoa p where p.nome like :pNome order by p.matricula", Pessoa.class);
		query.setParameter("pNome", "%"+nome+"%" );
		return query.getResultList();
		 
	}
	@Override
	public List<Pessoa> listarAtivas() {		
		TypedQuery<Pessoa> query = manager.createQuery("select p from Pessoa p where p.status=:pAtivo order by p.matricula", Pessoa.class);
		query.setParameter("pAtivo", Status.ATIVO );
		return query.getResultList();		 
	}

	@Override
	public List<Pessoa> listar() {
		TypedQuery<Pessoa> query = manager.createQuery("select p from Pessoa p order by p.matricula", Pessoa.class);
		return query.getResultList();
	}

	@Override
	public Pessoa login(String login, String senha) {
		TypedQuery<Usuario> query = manager.createQuery("select u from Usuario u where u.login=:uLogin and u.senha=:uSenha ", Usuario.class);
		query.setParameter("uLogin", login);
		query.setParameter("uSenha", senha);
		Pessoa pessoa = null;
		try {
			Usuario usuario = (Usuario) query.getSingleResult();
			pessoa =  obterPorIdUsuario(usuario);
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pessoa;
		
	}

	@Override
	public List<Aluno> obterAlunos() {
		TypedQuery<Aluno> query = manager.createQuery("select a from Aluno a order by a.matricula", Aluno.class);
		return query.getResultList();
	}

	@Override
	public List<Professor> obterProfessores() {
		TypedQuery<Professor> query = manager.createQuery("select p from Professor p order by p.matricula", Professor.class);
		return query.getResultList();
	}

	@Override
	public Aluno obterAluno(long matricula) {
		TypedQuery<Aluno> query = manager.createQuery("select a from Aluno a where a.matricula=:aId ", Aluno.class);
		query.setParameter("aId", matricula);
		return query.getSingleResult();
	}

	@Override
	public Professor obterProfessor(long matricula) {
		TypedQuery<Professor> query = manager.createQuery("select p from Professor p where p.matricula=:pId ", Professor.class);
		query.setParameter("pId", matricula);
		return query.getSingleResult();
		
	}
	

}
