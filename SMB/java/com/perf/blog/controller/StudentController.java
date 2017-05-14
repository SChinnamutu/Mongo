package com.perf.blog.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.perf.blog.model.StudentDetails;
import com.perf.blog.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value = "/student", method = RequestMethod.GET)  
	public String findAll(ModelMap model) {  
        model.addAttribute("studentList", studentService.listStudent());  
        return "student";  
    }
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)  
	public String save(@ModelAttribute StudentDetails studentDetails,ModelMap model) {  
		studentService.save(studentDetails);
        model.addAttribute("studentList", studentService.listStudent());  
        return "student";  
    }
	
	
	@RequestMapping(value = "/deleteDetails", method = RequestMethod.GET)  
	public String deleteDetails(HttpServletRequest request,ModelMap model) {  
		String studentId = request.getParameter("id");
		System.out.println("Deleting Student Id is " + studentId);
        model.addAttribute("studentList", studentService.getList(studentId));  
        return "student";  
    }
}
