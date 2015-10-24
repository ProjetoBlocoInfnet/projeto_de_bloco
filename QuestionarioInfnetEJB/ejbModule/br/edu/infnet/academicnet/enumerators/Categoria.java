package br.edu.infnet.academicnet.enumerators;

public enum Categoria {
	
	CURSO("Curso", "Avaliação geral da Pós-Graduação"), PROFESSOR("Professor","Avaliação do professor do módulo"), 
	MODULO_INFRA("Conteúdo e Infra-Estrutura do módulo","Avaliação de Conteúdo e infra-estrutura no módulo");
	
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
