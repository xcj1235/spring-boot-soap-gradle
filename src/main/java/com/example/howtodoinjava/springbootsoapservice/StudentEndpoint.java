package com.example.howtodoinjava.springbootsoapservice;

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

        return response;
    }
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "StudentDetailsRequest1")
    @ResponsePayload
    public StudentDetailsResponse1 getStudent1(@RequestPayload StudentDetailsRequest1 request1) {
        StudentDetailsResponse1 response = new StudentDetailsResponse1();
        response.setStudent1(StudentRepository.findStudent1(request1.getName1()));

        return response;
    }
}