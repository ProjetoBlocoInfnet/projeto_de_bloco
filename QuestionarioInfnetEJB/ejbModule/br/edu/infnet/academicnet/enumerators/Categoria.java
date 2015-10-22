package br.edu.infnet.academicnet.enumerators;

public enum Categoria {
	
	PROFESSOR("Professor"), EQUIPAMENTO("Equipamentos"), CURSO("Curso");
	
	private String categoria;
	
	private Categoria(String categoria) {
		this.categoria = categoria;
	}

	public String getCategoria() {
		return categoria;
	}

}
