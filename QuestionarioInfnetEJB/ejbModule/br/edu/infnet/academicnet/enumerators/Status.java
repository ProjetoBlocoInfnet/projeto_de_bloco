package br.edu.infnet.academicnet.enumerators;

public enum Status {
	
	ATIVO("Ativo"), INATIVO("Inativo");
	
	private String status;
	
	private Status(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
	
}
