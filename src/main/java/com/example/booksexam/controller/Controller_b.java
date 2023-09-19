package com.example.booksexam.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.booksexam.models.Books;
import com.example.booksexam.models.Publisher;
import com.example.booksexam.repository.Repository_b;

@RestController
public class Controller_b {
	private final Repository_b rep;
	
	@Autowired
	public Controller_b(Repository_b rep) {
		this.rep=rep;
	}
	
	@GetMapping(value="/publish")
	public ArrayList<Publisher> getAllPublishers(){
		return rep.getAllPublishers();
		
	}
	@RequestMapping(value="/publish/{id}",method=RequestMethod.DELETE)
	public void delete(@PathVariable("id") int id) {
		rep.delPublisher(id);
	}
	
	@RequestMapping(value="/addpublish",method=RequestMethod.POST)
	@ResponseBody
	public void addPublisher( Publisher obj) {
		System.out.println("this is a function in controller");
		System.out.println(obj.getPublisher_name());
		rep.addPublisher(obj);
		
		}
	
	

	@RequestMapping(value="/show",method=RequestMethod.POST)
	@ResponseBody
	public ArrayList<Books> showBooks(@RequestParam("publisher_id") Integer id,Model model) {
		System.out.println("this is a show books function in controller");
		System.out.println(id);
		
		System.out.println(rep.showBooks(id));
		
			return rep.showBooks(id);

		
		
		
	}

}