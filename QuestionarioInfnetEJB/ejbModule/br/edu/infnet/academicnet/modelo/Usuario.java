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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="tbl_usuario")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idUsuario;
	
	@Column(length=100)
	private String login;
	
	
	private String senha;
	
	@ManyToOne()
	@JoinColumn(name = "perfil_id")
	@XmlTransient
	private Perfil perfil;
	
	@OneToOne(mappedBy = "usuario")	
	private Pessoa pessoa;
	
	public Usuario() {
		
	}
	
		

	public Usuario(String login, String senha, Perfil perfil, Pessoa pessoa) {
		super();
		this.login = login;
		this.senha = senha;
		this.perfil = perfil;
		this.pessoa = pessoa;
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

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
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
