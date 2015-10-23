package br.edu.infnet.academicnet.enumerators;

public enum StatusAvaliacao {
	
	CRIADO("Criado"), EM_ANDAMENTO("Em Andamento"), FINALIZADO("Finalizado");
	
	private String status;
	
	private StatusAvaliacao(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
	
}
