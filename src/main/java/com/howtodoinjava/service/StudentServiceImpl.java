package com.howtodoinjava.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.howtodoinjava.domainobject.Student;
import com.howtodoinjava.domainobject.StudentDetailsRequest;

@Service
@SuppressWarnings("resource")
public class StudentServiceImpl implements StudentService {
	private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

	@Override
	public Student getUsername(StudentDetailsRequest req) {
		Assert.notNull(req.getName(), "The Student's name must not be null");
		logger.info(req.getName() + "-----------StudentServiceImpl----------");

		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		StudentRepository repository = context.getBean("StudentRepository", StudentRepository.class);

		return repository.findStudent(req);
	}
}
