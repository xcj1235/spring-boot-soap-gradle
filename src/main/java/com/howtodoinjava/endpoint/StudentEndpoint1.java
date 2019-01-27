package com.howtodoinjava.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.howtodoinjava.domainobject.StudentDetailsRequest1;
import com.howtodoinjava.domainobject.StudentDetailsResponse1;
import com.howtodoinjava.service.StudentServiceImpl1;

@Endpoint
public class StudentEndpoint1
{
    private static final String NAMESPACE_URI = "http://www.howtodoinjava.com/domainobject";
    private static final Logger logger = LoggerFactory.getLogger(StudentEndpoint1.class);

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "StudentDetailsRequest1")
    @ResponsePayload
    public StudentDetailsResponse1 getStudent(@RequestPayload StudentDetailsRequest1 request1) {
        StudentDetailsResponse1 response1 = new StudentDetailsResponse1();
        StudentServiceImpl1 studentServiceImpl1 = new StudentServiceImpl1(); 
        response1.setStudent1(studentServiceImpl1.getUsername1(request1));
        logger.info(request1.getName1());
        
        logger.info("Name1:"+response1.getStudent1().getName1());
        logger.info("Address1:"+response1.getStudent1().getAddress1());
        logger.info("Standard1:"+String.valueOf(response1.getStudent1().getStandard1()));
        return response1;
    }
}