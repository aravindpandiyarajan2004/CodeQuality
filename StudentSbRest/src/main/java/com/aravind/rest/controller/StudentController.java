package com.aravind.rest.controller;

import java.util.List;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aravind.rest.model.Student;
import com.aravind.rest.serviceimpl.StudentServiceImpl;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/student")
@CrossOrigin("http://localhost:3000")
public class StudentController {
	
	
	StudentServiceImpl service;
	
	static final String SUCCESS = "Success";
	static final String FAILURE = "Failure";
	
	public StudentServiceImpl getService() {
		return service;
	}

	public void setService(StudentServiceImpl service) {
		this.service = service;
	}

	@PostMapping
	public String insertStudent(@RequestBody Student stud) {
		System.out.println(stud);
		String msg = "";
		
		try {
			service.addStudent(stud);
			msg = SUCCESS;
		}
		catch(Exception e) {
			msg = FAILURE;
		}
		
		return msg;
	}
	
	@GetMapping("{id}")
	public Student getStudentById(@PathVariable("id") int id) {
		
		return service.getStudent(id);
	}
	
	@GetMapping("/all")
	public List<Student> getStudents() {
		
		return service.getAllStudents();
	}
	
	@PutMapping
	public String updateStudent(@RequestBody Student stud) {
	String msg = "";
	
	try {
		service.updateStudent(stud);
		msg = SUCCESS;
	}
	catch(Exception e) {
		msg = FAILURE;
	}
	
	return msg;
}
	
	@DeleteMapping("{id}")
	public String deleteStudentById(@PathVariable("id") int id) {
		String msg = "";
		
		try {
			service.deleteStudent(id);
			msg = SUCCESS;
		}
		catch(Exception e) {
			msg = FAILURE;
		}
		
		return msg;
		
	}
	

}
