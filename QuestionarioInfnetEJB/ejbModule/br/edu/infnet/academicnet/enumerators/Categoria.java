package br.edu.infnet.academicnet.enumerators;

public enum Categoria {
	
	CURSO("Curso", "Avalia��o geral da P�s-Gradua��o"), PROFESSOR("Professor","Avalia��o do professor do m�dulo"), 
	MODULO_INFRA("Conte�do e Infra-Estrutura do m�dulo","Avalia��o de Conte�do e infra-estrutura no m�dulo");
	
	private String categoria;
	private String titulo;
	
	private Categoria(String categoria, String titulo) {
		this.categoria = categoria;
		this.titulo = titulo;
	}

	public String getCategoria() {
		return categoria;
	}

	public String getTitulo() {
		return titulo;
	}
	
	

}
