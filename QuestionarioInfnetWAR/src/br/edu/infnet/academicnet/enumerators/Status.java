package br.edu.infnet.academicnet.enumerators;

public enum Status {
	
	CRIADO("Criado"), EM_ANDAMENTO("Em Andamento"), FINALIZADO("Finalizado");
	
	private String status;
	
	private Status(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
	
}
