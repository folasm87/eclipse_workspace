/**
 * EmployeeAnniversaryServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.multivision.webservice;

public class EmployeeAnniversaryServiceLocator extends org.apache.axis.client.Service implements com.multivision.webservice.EmployeeAnniversaryService {

    public EmployeeAnniversaryServiceLocator() {
    }


    public EmployeeAnniversaryServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public EmployeeAnniversaryServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for EmployeeAnniversary
    private java.lang.String EmployeeAnniversary_address = "http://localhost:7001/eHRMS/services/EmployeeAnniversary";

    public java.lang.String getEmployeeAnniversaryAddress() {
        return EmployeeAnniversary_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String EmployeeAnniversaryWSDDServiceName = "EmployeeAnniversary";

    public java.lang.String getEmployeeAnniversaryWSDDServiceName() {
        return EmployeeAnniversaryWSDDServiceName;
    }

    public void setEmployeeAnniversaryWSDDServiceName(java.lang.String name) {
        EmployeeAnniversaryWSDDServiceName = name;
    }

    public com.multivision.webservice.EmployeeAnniversary getEmployeeAnniversary() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(EmployeeAnniversary_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getEmployeeAnniversary(endpoint);
    }

    public com.multivision.webservice.EmployeeAnniversary getEmployeeAnniversary(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.multivision.webservice.EmployeeAnniversarySoapBindingStub _stub = new com.multivision.webservice.EmployeeAnniversarySoapBindingStub(portAddress, this);
            _stub.setPortName(getEmployeeAnniversaryWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setEmployeeAnniversaryEndpointAddress(java.lang.String address) {
        EmployeeAnniversary_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.multivision.webservice.EmployeeAnniversary.class.isAssignableFrom(serviceEndpointInterface)) {
                com.multivision.webservice.EmployeeAnniversarySoapBindingStub _stub = new com.multivision.webservice.EmployeeAnniversarySoapBindingStub(new java.net.URL(EmployeeAnniversary_address), this);
                _stub.setPortName(getEmployeeAnniversaryWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("EmployeeAnniversary".equals(inputPortName)) {
            return getEmployeeAnniversary();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://com.multivision.webservice", "EmployeeAnniversaryService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://com.multivision.webservice", "EmployeeAnniversary"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("EmployeeAnniversary".equals(portName)) {
            setEmployeeAnniversaryEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
