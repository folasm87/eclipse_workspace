package org.example.calculatorwsdlfile;

import javax.jws.WebService;
import javax.xml.ws.BindingType;

/**
 * This class was generated by the JAX-WS RI. JAX-WS RI 2.2.8-b13937 Generated
 * source version: 2.2
 * 
 */
@WebService(portName = "CalculatorWSDLFileSOAP", serviceName = "CalculatorWSDLFile", targetNamespace = "http://www.example.org/CalculatorWSDLFile/", wsdlLocation = "/wsdls/calculatorWSDLFile.wsdl", endpointInterface = "org.example.calculatorwsdlfile.CalculatorWSDLFile")
@BindingType("http://schemas.xmlsoap.org/wsdl/soap/http")
public class CalculatorWSDLFile_CalculatorWSDLFileSOAPImpl implements
		CalculatorWSDLFile {

	public CalculatorWSDLFile_CalculatorWSDLFileSOAPImpl() {
	}

	/**
	 * 
	 * @param second
	 * @param first
	 * @return returns int
	 */
	public int add(int first, int second) {
		// replace with your impl here
		return 0;
	}

}