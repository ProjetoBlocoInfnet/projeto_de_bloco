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
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.edu.infnet.academicnet.enumerators.TipoResposta;

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

	//TODO Verificar porque essa chave estrangeira n�o funciona. Ela � necess�ria para saber que a resposta � de uma avalia��o
	/*@ManyToOne 
	@JoinColumn(name="avaliacao_id") 
	private Avaliacao avaliacao;*/
	
	@OneToOne
	@JoinColumn(name="agendamentoAvaliacao_id")
	private AgendamentoAvaliacao agendamentoAvaliacao;
	
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
		this.calculaMedia();
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

	public AgendamentoAvaliacao getAgendamentoAvaliacao() {
		return agendamentoAvaliacao;
	}

	public void setAgendamentoAvaliacao(AgendamentoAvaliacao agendamentoAvaliacao) {
		this.agendamentoAvaliacao = agendamentoAvaliacao;
	}

	public Boolean efetuarAvaliacao() {
		return null;
	}

	public void calculaMedia()
	{
		int total=0;
		int qtdLikert=0;
		for(Map.Entry<Questao, String> resposta : respostas.entrySet())
		{
			System.out.println("Comparando questao " + resposta.getKey().getIdQuestao() + " com likert " + resposta.getKey().getTipoResposta().compareTo(TipoResposta.LIKERT) + " de resposta " + resposta.getValue());
//			System.out.println(resposta.getValue());
			if(resposta.getKey().getTipoResposta().compareTo(TipoResposta.LIKERT) == 0)
			{
				total+=Integer.valueOf(resposta.getValue());
				qtdLikert++;
			}
		}
		this.media = total/qtdLikert;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((agendamentoAvaliacao == null) ? 0 : agendamentoAvaliacao
						.hashCode());
		result = prime * result + ((aluno == null) ? 0 : aluno.hashCode());
		result = prime * result
				+ (int) (idResultadoAvaliacao ^ (idResultadoAvaliacao >>> 32));
		long temp;
		temp = Double.doubleToLongBits(media);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((respostas == null) ? 0 : respostas.hashCode());
		result = prime * result + ((turma == null) ? 0 : turma.hashCode());
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
		ResultadoAvaliacao other = (ResultadoAvaliacao) obj;
		if (agendamentoAvaliacao == null) {
			if (other.agendamentoAvaliacao != null)
				return false;
		} else if (!agendamentoAvaliacao.equals(other.agendamentoAvaliacao))
			return false;
		if (aluno == null) {
			if (other.aluno != null)
				return false;
		} else if (!aluno.equals(other.aluno))
			return false;
		if (idResultadoAvaliacao != other.idResultadoAvaliacao)
			return false;
		if (Double.doubleToLongBits(media) != Double
				.doubleToLongBits(other.media))
			return false;
		if (respostas == null) {
			if (other.respostas != null)
				return false;
		} else if (!respostas.equals(other.respostas))
			return false;
		if (turma == null) {
			if (other.turma != null)
				return false;
		} else if (!turma.equals(other.turma))
			return false;
		return true;
	}
	
	

}
