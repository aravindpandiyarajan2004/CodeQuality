package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Student;
import com.example.demo.service.StudentServiceImplementation;

@Controller
public class StudentController {

	@Autowired
	 StudentServiceImplementation service;
	
//	public StudentServiceImplementation getService() {
//		return service;
//	}
//	public void setService(StudentServiceImplementation service) {
//		this.service = service;
//	}
	@GetMapping("Insert")
	public ModelAndView loadInsert() {
		ModelAndView mv = new ModelAndView("Insert");
		return mv;
	}
	@PostMapping("Insertion")
	public ModelAndView performInsert( @ModelAttribute("bean") Student stud) {
		
		String msg = service.addStudent(stud);
		ModelAndView mv = new ModelAndView("Insert");
		mv.addObject("Action", msg);
		return mv;	
	}
	@GetMapping("Delete")
	public ModelAndView loadDelete() {
		List <Integer> idList = service.getIdList();
		List <String> nameList = service.getNameList();
		ModelAndView mv = new ModelAndView("Delete");
		mv.addObject("IdList",idList);
		mv.addObject("NameList", nameList);
		mv.addObject("Action", null);
		return mv;
		
	}
	@PostMapping("Deletion")
	public ModelAndView dodelete(@RequestParam("sid") int id) {
		
		service.deleteStudent(id);
		List<Integer> idList = service.getIdList();
		ModelAndView mv = new ModelAndView("Delete");
		mv.addObject("IdList",idList);
		mv.addObject("Action","Success");
		return mv;
		
	}
	@PostMapping("DeletionByName")
	public ModelAndView dodeleteByName(@RequestParam("sname") String sname) {
		
		service.deleteStudentBySname(sname);
		List<String> nameList = service.getNameList();
		ModelAndView mv = new ModelAndView("Delete");
		mv.addObject("NameList",nameList);
		mv.addObject("Action","Success");
		return mv;
		
	}
	
	@RequestMapping("Update")
	public ModelAndView loadUpdate() {
		List<Integer> idList = service.getIdList();
		ModelAndView mv = new ModelAndView("Update");
		mv.addObject("IdList",idList);
		return mv;
	}
	
	@RequestMapping("Fetch")
	public ModelAndView doFetch(@RequestParam("sid") int id) {
		Student stud = service.fetchOne(id);
		List<Integer> idList = service.getIdList();
		ModelAndView mv = new ModelAndView("Update");
		mv.addObject("Stud",stud);
		mv.addObject("IdList",idList);
		return mv;
	}
 
	@PostMapping("Updation")
	public ModelAndView doUpdate(@ModelAttribute("bean") Student stud) {
		List<Integer> idList = service.getIdList();
		service.updateStudent(stud);
		ModelAndView mv = new ModelAndView("Update");
		mv.addObject("Action","Success");
		mv.addObject("IdList",idList);
		return mv;
	}
	@RequestMapping("View")
	public ModelAndView loadView(@RequestParam("sid") int id) {
		Student stud = service.fetchOne(id);
		List<Integer> idList = service.getIdList();
		ModelAndView mv = new ModelAndView("View");
		mv.addObject("IdList",idList);
		return mv;
		
		
		
	}
	
	
	
	
}
