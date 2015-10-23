package br.edu.infnet.academicnet.modelo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_resultadoAvaliacao")
public class ResultadoAvaliacao implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idResultadoAvaliacao;
	
	@Column(nullable=false)
	private double media;
	
	@ElementCollection
	@MapKeyColumn(name="idQuestao")
	@Column(name="respostas")
	@CollectionTable(name="questoes_respostas", joinColumns = @JoinColumn(name="resposta_valor"))
	private Map<Questao,String> respostas = new HashMap<Questao,String>();
	
	@OneToOne
	@JoinColumn(name="aluno_id")
	private Aluno aluno;
	
	@OneToOne
	@JoinColumn(name="turma_id")
	private Turma turma;

	//TODO Verificar porque essa chave estrangeira não funciona. Ela é necessária para saber que a resposta é de uma avaliação
	@ManyToOne 
	@JoinColumn(name="avaliacao_id") 
	private Avaliacao avaliacao;
	
	public ResultadoAvaliacao()
	{
		
	}
	
	public long getIdResultadoAvaliacao() {
		return idResultadoAvaliacao;
	}

	public void setIdResultadoAvaliacao(long idResultadoAvaliacao) {
		this.idResultadoAvaliacao = idResultadoAvaliacao;
	}

	public double getMedia() {
		return media;
	}

	public void setMedia(double media) {
		this.media = media;
	}

	public Map<Questao, String> getRespostas() {
		return respostas;
	}

	public void setRespostas(Map<Questao, String> respostas) {
		this.respostas = respostas;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Boolean efetuarAvaliacao() {
		return null;
	}

}
