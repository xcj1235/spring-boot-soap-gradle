package com.howtodoinjava.endpoint;

import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPFault;
import javax.xml.ws.soap.SOAPFaultException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.howtodoinjava.domainobject.StudentDetailsRequest;
import com.howtodoinjava.domainobject.StudentDetailsResponse;
import com.howtodoinjava.service.StudentServiceImpl;

@Endpoint
public class StudentEndpoint {
	private static final String NAMESPACE_URI = "http://www.howtodoinjava.com/domainobject";

	private static final Logger logger = LoggerFactory.getLogger(StudentEndpoint.class);

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "StudentDetailsRequest")
	@ResponsePayload
	public StudentDetailsResponse getStudent(@RequestPayload StudentDetailsRequest request) throws SOAPException {
		StudentDetailsResponse response = new StudentDetailsResponse();
		StudentServiceImpl studentServiceImpl = new StudentServiceImpl();
		response.setStudent(studentServiceImpl.getUsername(request));
//		logger.info(request.getName());
//
//		logger.info("Name:" + response.getStudent().getName());
//		logger.info("Address:" + response.getStudent().getAddress());
//		logger.info("Standard:" + String.valueOf(response.getStudent().getStandard()));
		if (ObjectUtils.isEmpty(request.getName())) {
			SOAPFault fault;
			fault = SOAPFactory.newInstance().createFault();
			fault.setFaultString("400");
			throw new SOAPFaultException(fault);
			
		}
		if (ObjectUtils.isEmpty(response.getStudent())) {
			SOAPFault fault;
			fault = SOAPFactory.newInstance().createFault();
			fault.setFaultString("500");
			throw new SOAPFaultException(fault);
		}
		return response;
	}

}