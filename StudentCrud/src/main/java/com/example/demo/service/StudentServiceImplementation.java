package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class StudentServiceImplementation implements StudentService {
	@Autowired
	StudentRepo repo;
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public String addStudent(Student stud) {
		
		repo.save(stud);
		return "Success";
		
	}
	public List<Integer> getIdList(){
		
		List<Integer> idList = repo.fetchIdList();
		return idList;
	}
	
	public void deleteStudent(int sid) {
		repo.deleteById(sid);
	}
	public List<String> getNameList() {
		List<String> nameList = repo.fetchNameList();
		return nameList;
		
	}

	public void deleteStudentBySname(String sname) {
		// TODO Auto-generated method stub
		repo.deleteBySname(sname);
	}
	
	public Student fetchOne(int sid) {
		Student student = repo.getById(sid);
		return student;
	}
	public void updateStudent(Student stud) {
		repo.save(stud);
	}
	
	

}
