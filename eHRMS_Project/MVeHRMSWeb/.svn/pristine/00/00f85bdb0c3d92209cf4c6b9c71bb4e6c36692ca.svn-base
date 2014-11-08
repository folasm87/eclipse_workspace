package com.multivision.webservice;

public class EmployeeAnniversaryProxy implements com.multivision.webservice.EmployeeAnniversary {
  private String _endpoint = null;
  private com.multivision.webservice.EmployeeAnniversary employeeAnniversary = null;
  
  public EmployeeAnniversaryProxy() {
    _initEmployeeAnniversaryProxy();
  }
  
  public EmployeeAnniversaryProxy(String endpoint) {
    _endpoint = endpoint;
    _initEmployeeAnniversaryProxy();
  }
  
  private void _initEmployeeAnniversaryProxy() {
    try {
      employeeAnniversary = (new com.multivision.webservice.EmployeeAnniversaryServiceLocator()).getEmployeeAnniversary();
      if (employeeAnniversary != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)employeeAnniversary)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)employeeAnniversary)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (employeeAnniversary != null)
      ((javax.xml.rpc.Stub)employeeAnniversary)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.multivision.webservice.EmployeeAnniversary getEmployeeAnniversary() {
    if (employeeAnniversary == null)
      _initEmployeeAnniversaryProxy();
    return employeeAnniversary;
  }
  
  public java.lang.String[] getCurrentMonthAnniversaryEmployeesName() throws java.rmi.RemoteException{
    if (employeeAnniversary == null)
      _initEmployeeAnniversaryProxy();
    return employeeAnniversary.getCurrentMonthAnniversaryEmployeesName();
  }
  
  
}