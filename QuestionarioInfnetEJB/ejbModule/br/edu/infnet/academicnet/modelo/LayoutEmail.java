package br.edu.infnet.academicnet.modelo;

public class LayoutEmail {

	private int idLayout;

	private String layout;

	private String descricaoLayout;

	public LayoutEmail()
	{
		
	}
	
	public LayoutEmail(int idLayout, String layout, String descricaoLayout)
	{
		super();
		this.idLayout = idLayout;
		this.layout = layout;
		this.descricaoLayout = descricaoLayout;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idLayout;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LayoutEmail other = (LayoutEmail) obj;
		if (idLayout != other.idLayout)
			return false;
		return true;
	}

	public int getIdLayout() {
		return idLayout;
	}

	public void setIdLayout(int idLayout) {
		this.idLayout = idLayout;
	}

	public String getLayout() {
		return layout;
	}

	public void setLayout(String layout) {
		this.layout = layout;
	}

	public String getDescricaoLayout() {
		return descricaoLayout;
	}

	public void setDescricaoLayout(String descricaoLayout) {
		this.descricaoLayout = descricaoLayout;
	}

	public Boolean incluirLayout(LayoutEmail layout) {
		return null;
	}

	public Boolean alterarLayout(LayoutEmail layout) {
		return null;
	}

	public Boolean consultarLayout(LayoutEmail layout) {
		return null;
	}

	public Boolean excluirLayout(LayoutEmail layout) {
		return null;
	}

}
