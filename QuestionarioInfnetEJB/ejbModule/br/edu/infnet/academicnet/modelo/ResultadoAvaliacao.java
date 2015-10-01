package br.edu.infnet.academicnet.modelo;

import java.util.List;

public class ResultadoAvaliacao {

	private int media;

	private List<Resposta> respostas;

	public int getMedia() {
		return media;
	}

	public void setMedia(int media) {
		this.media = media;
	}

	public List<Resposta> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<Resposta> respostas) {
		this.respostas = respostas;
	}

	public Boolean efetuarAvaliacao() {
		return null;
	}

}
