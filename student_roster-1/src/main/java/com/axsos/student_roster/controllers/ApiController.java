package com.axsos.student_roster.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.axsos.student_roster.models.Contact;
import com.axsos.student_roster.models.Student;
import com.axsos.student_roster.services.ApiService;

@Controller
public class ApiController {
	
	private final ApiService apiService ;

	public ApiController(ApiService apiService) {
		super();
		this.apiService = apiService;
	}
	
	
	@RequestMapping("/students")
	public String main (Model model) {
		model.addAttribute("students",apiService.allStudents());
		return "index.jsp";
	}
	
	@RequestMapping("/students/new")
	public String newStudent (@ModelAttribute("student") Student student) {
		
		return "newStudent.jsp";
	}
	
	@RequestMapping(value="/students/new", method =RequestMethod.POST)
	public String createStudent (@Valid@ModelAttribute("student") Student student, BindingResult result) {
		
		if(result.hasErrors() ) {
			return "newStudent.jsp";
		}
		apiService.createStudent(student);
		return "redirect:/students";
	}
	
	@RequestMapping("/contacts/new")
	public String newContact (@ModelAttribute("contact") Contact contact, Model model) {
		model.addAttribute("stu",apiService.allNullStudents());

		return "newContact.jsp";
	}
	
	@RequestMapping(value="/contacts/new", method =RequestMethod.POST)
	public String createContact (@Valid@ModelAttribute("contact") Contact contact,Model model, BindingResult result) {
		
		if(result.hasErrors() ) {
			return "newContact.jsp";
		}
		model.addAttribute("stu",apiService.allStudents());
		apiService.createContact(contact);
		return "redirect:/students";
	}
	
	
	
	

}
