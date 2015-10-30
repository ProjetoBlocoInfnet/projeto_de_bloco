package localhost.test;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import localhost.ws.Aluno;
import localhost.ws.AlunoServiceSoapBindingStub;
import localhost.ws.AlunoService_ServiceLocator;

public class TestWebservice {

	public static void main(String[] args) throws ServiceException, RemoteException
	{
		AlunoService_ServiceLocator asLocator = new AlunoService_ServiceLocator();
		asLocator.setEndpointAddress("AlunoServicePort",
		                    "http://localhost:8080/QuestionarioInfnetEJB/AlunoService/AlunoService");
		AlunoServiceSoapBindingStub bind = (AlunoServiceSoapBindingStub) asLocator.getAlunoServicePort();
		Aluno alunos[] = bind.todosOsAlunos();
		for(int i=0; i <alunos.length; i++)
		{
			System.out.println("Aluno: " + alunos[i].getNome());
		}
	}

}
