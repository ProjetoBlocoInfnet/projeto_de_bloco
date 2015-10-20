package br.edu.infnet.academicnet.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_usuario")
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idUsuario;
	
	@Column(nullable=false, unique = true)
	private String login;
	
	@Column(nullable=false)
	private String senha;
	
	@ManyToOne
	@JoinColumn(name = "perfil_id")
	private Perfil perfil;
	
	@OneToOne(mappedBy = "usuario")
	private Pessoa pessoa;
	
	public Usuario() {
		
	}
	
	
	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}	

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}


	public Boolean efetuarLogin(String login, String senha) {
		return null;
	}

	public Boolean incluirLogin(Usuario usuario) {
		return null;
	}

	public Boolean alterarLogin(Usuario usuario) {
		return null;
	}

	public Boolean excluirLogin(Usuario usuario) {
		return null;
	}

	public Boolean consultarLogin(Usuario usuario) {
		return null;
	}

}
