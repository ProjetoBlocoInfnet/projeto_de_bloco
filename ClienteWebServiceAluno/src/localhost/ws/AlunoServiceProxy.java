package localhost.ws;

public class AlunoServiceProxy implements localhost.ws.AlunoService_PortType {
  private String _endpoint = null;
  private localhost.ws.AlunoService_PortType alunoService_PortType = null;
  
  public AlunoServiceProxy() {
    _initAlunoServiceProxy();
  }
  
  public AlunoServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initAlunoServiceProxy();
  }
  
  private void _initAlunoServiceProxy() {
    try {
      alunoService_PortType = (new localhost.ws.AlunoService_ServiceLocator()).getAlunoServicePort();
      if (alunoService_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)alunoService_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)alunoService_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (alunoService_PortType != null)
      ((javax.xml.rpc.Stub)alunoService_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public localhost.ws.AlunoService_PortType getAlunoService_PortType() {
    if (alunoService_PortType == null)
      _initAlunoServiceProxy();
    return alunoService_PortType;
  }
  
  public localhost.ws.Pessoa[] buscarUsuariosPorNome(java.lang.String nome) throws java.rmi.RemoteException{
    if (alunoService_PortType == null)
      _initAlunoServiceProxy();
    return alunoService_PortType.buscarUsuariosPorNome(nome);
  }
  
  public localhost.ws.Aluno[] todosOsAlunos() throws java.rmi.RemoteException{
    if (alunoService_PortType == null)
      _initAlunoServiceProxy();
    return alunoService_PortType.todosOsAlunos();
  }
  
  
}