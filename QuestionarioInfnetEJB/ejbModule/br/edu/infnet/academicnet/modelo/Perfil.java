package br.edu.infnet.academicnet.modelo;

public class Perfil {

	private int idPerfil;

	private String nomePerfil;

	private String descricao;

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
