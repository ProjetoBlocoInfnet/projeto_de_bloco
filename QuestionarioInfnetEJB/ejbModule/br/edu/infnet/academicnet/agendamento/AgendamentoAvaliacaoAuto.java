package br.edu.infnet.academicnet.agendamento;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
public class AgendamentoAvaliacaoAuto
{
	//O agendamento executa a cada dia �s 00hrs
	@Schedule(hour="0")
	public void IniciarAvaliacao()
	{
		
	}
}
