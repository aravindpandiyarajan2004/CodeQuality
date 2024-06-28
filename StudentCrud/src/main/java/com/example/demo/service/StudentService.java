package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Student;

public interface StudentService   {
	
	public String addStudent(Student stud);
	public List<Integer> getIdList();
	public void deleteStudent(int id);
	Student fetchOne(int sid);
//	public String updateStudent(Student stud);
	

}
