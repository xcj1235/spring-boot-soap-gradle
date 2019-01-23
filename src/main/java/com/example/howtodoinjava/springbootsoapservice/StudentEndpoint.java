package com.example.howtodoinjava.springbootsoapservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.howtodoinjava.xml.school.StudentDetailsRequest;
import com.howtodoinjava.xml.school.StudentDetailsRequest1;
import com.howtodoinjava.xml.school.StudentDetailsResponse;
import com.howtodoinjava.xml.school.StudentDetailsResponse1;

@Endpoint
public class StudentEndpoint
{
    private static final String NAMESPACE_URI = "http://www.howtodoinjava.com/xml/school";

    private static final Logger logger = LoggerFactory.getLogger(StudentEndpoint.class);
    private StudentRepository StudentRepository;

    @Autowired
    public StudentEndpoint(StudentRepository StudentRepository) {
        this.StudentRepository = StudentRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "StudentDetailsRequest")
    @ResponsePayload
    public StudentDetailsResponse getStudent(@RequestPayload StudentDetailsRequest request) {
        StudentDetailsResponse response = new StudentDetailsResponse();
        response.setStudent(StudentRepository.findStudent(request.getName()));

        logger.info(request.getName());
        return response;
    }

}