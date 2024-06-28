package com.aravind.rest.serviceimpl;

import java.util.List;


import org.springframework.stereotype.Service;

import com.aravind.rest.model.Student;
import com.aravind.rest.repository.StudentRepo;
import com.aravind.rest.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	
	StudentRepo repo;
	

	public StudentRepo getRepo() {
		return repo;
	}

	public void setRepo(StudentRepo repo) {
		this.repo = repo;
	}

	@Override
	public void addStudent(Student stud) {
		repo.save(stud);
	}

	@Override
	public Student getStudent(int id) {
		return repo.findById(id).get();	
	}

	public List<Student> getAllStudents() {
		return repo.findAll();
	}

	@Override
	public void updateStudent(Student stud) {
		repo.save(stud);
		
	}

	@Override
	public void deleteStudent(int id) {
		repo.deleteById(id);
		
	}
	
	
}
