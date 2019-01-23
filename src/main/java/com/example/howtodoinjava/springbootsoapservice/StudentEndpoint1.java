package com.example.howtodoinjava.springbootsoapservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.howtodoinjava.xml.school.StudentDetailsRequest1;
import com.howtodoinjava.xml.school.StudentDetailsResponse1;

@Endpoint
public class StudentEndpoint1
{
    private static final String NAMESPACE_URI = "http://www.howtodoinjava.com/xml/school";
    private static final Logger logger = LoggerFactory.getLogger(StudentEndpoint1.class);
    private StudentRepository StudentRepository;

    @Autowired
    public StudentEndpoint1(StudentRepository StudentRepository) {
        this.StudentRepository = StudentRepository;
    }
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "StudentDetailsRequest1")
    @ResponsePayload
    public StudentDetailsResponse1 getStudent1(@RequestPayload StudentDetailsRequest1 request1) {
        StudentDetailsResponse1 response = new StudentDetailsResponse1();
        response.setStudent1(StudentRepository.findStudent1(request1.getName1()));
        logger.info(request1.getName1());
        return response;
    }
}