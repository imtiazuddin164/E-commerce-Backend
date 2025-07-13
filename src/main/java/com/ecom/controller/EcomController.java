package com.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ecom.dao.EcomDAO;
import com.ecom.model.Ecom;

@RestController
public class EcomController {

	@Autowired
	EcomDAO ecomDAO;
	
//	@GetMapping(path="/test")
//	public ModelAndView index() {
//		return new ModelAndView("test/abc");	
//	}

	
	
//	@GetMapping(path="/")
//	public ModelAndView index() {
//		return new ModelAndView("index");	
//	}
	
	@GetMapping(path="/aman")
	public List<Ecom> getAllUsers(){
		System.out.println("hello");
		
		List<Ecom> imt = ecomDAO.getAllUsers();
		return imt;
	}
}