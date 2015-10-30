/**
 * AlunoService_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package localhost.ws;

public interface AlunoService_PortType extends java.rmi.Remote {
    public localhost.ws.Pessoa[] buscarUsuariosPorNome(java.lang.String nome) throws java.rmi.RemoteException;
    public localhost.ws.Aluno[] todosOsAlunos() throws java.rmi.RemoteException;
}
