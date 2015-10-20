package br.edu.infnet.academicnet.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_perfil")
public class Perfil implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPerfil;
	
	@Column(nullable=false, unique = true)
	private String nomePerfil;

	private String descricao;
	
	@OneToMany(mappedBy = "perfil")
	@JoinColumn(name = "perfil_id")
	private List<Usuario> usuarios;

	public Perfil()
	{
		
	}
	
	public Perfil(int idPerfil, String nomePerfil, String descricao)
	{
		super();
		this.idPerfil = idPerfil;
		this.nomePerfil = nomePerfil;
		this.descricao = descricao;
	}
	
	public int getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getNomePerfil() {
		return nomePerfil;
	}

	public void setNomePerfil(String nomePerfil) {
		this.nomePerfil = nomePerfil;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	
	public Boolean incluirPerfil(Perfil perfil) {
		return null;
	}

	public Boolean alterarPerfil(Perfil perfil) {
		return null;
	}

	public Boolean consultarPerfil(Perfil perfil) {
		return null;
	}

	public Boolean excluirPerfil(Perfil perfil) {
		return null;
	}

}
