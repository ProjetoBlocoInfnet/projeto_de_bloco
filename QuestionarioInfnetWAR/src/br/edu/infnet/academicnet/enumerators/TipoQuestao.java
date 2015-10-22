package br.edu.infnet.academicnet.enumerators;

public enum TipoQuestao {
	
	PROFESSOR("Professor"), EQUIPAMNETO("Equipamentos"), CUSRO("Curso");
	
	private String tipo;
	
	private TipoQuestao(String tipo) {
		this.tipo = tipo;
	}

	public String getTIpo() {
		return tipo;
	}

}
