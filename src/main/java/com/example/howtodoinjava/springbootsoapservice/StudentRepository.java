package com.example.howtodoinjava.springbootsoapservice;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.howtodoinjava.xml.school.Student;
import com.howtodoinjava.xml.school.Student1;

@Component
public class StudentRepository {
    private static final Map<String, Student> students = new HashMap<>();
    private static final Map<String, Student1> students1 = new HashMap<>();
    private static final Logger logger = LoggerFactory.getLogger(StudentRepository.class);
    @PostConstruct
    public void initData() {

        Student student = new Student();
        student.setName("Sajal");
        student.setStandard(5);
        student.setAddress("Pune");
        students.put(student.getName(), student);

        student = new Student();
        student.setName("Kajal");
        student.setStandard(5);
        student.setAddress("Chicago");
        students.put(student.getName(), student);

        Student1 student1 = new Student1();
        student1.setName1("Lokesh");
        student1.setStandard1(6);
        student1.setAddress1("Delhi");
        students1.put(student1.getName1(), student1);

        student1 = new Student1();
        student1.setName1("Sukesh");
        student1.setStandard1(7);
        student1.setAddress1("Noida");
        students1.put(student1.getName1(), student1);
    }

    public Student findStudent(String name) {
        Assert.notNull(name, "The Student's name must not be null");
        logger.info(name+"-----------000----------");
        logger.info(name+"-----------000----------");
        logger.info(name+"-----------000----------");
        return students.get(name);
    }
    
    public Student1 findStudent1(String name) {
        Assert.notNull(name, "The Student's name must not be null");
        logger.info(name+"-----------111----------");
        logger.info(name+"-----------111----------");
        logger.info(name+"-----------111----------");
        return students1.get(name);
    }
}