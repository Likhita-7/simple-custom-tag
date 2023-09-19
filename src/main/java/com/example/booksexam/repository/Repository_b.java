package com.example.booksexam.repository;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.booksexam.dao.DaoImp;
import com.example.booksexam.models.Books;
import com.example.booksexam.models.Publisher;

@Repository
public class Repository_b {
	private final DaoImp dao;
	
	@Autowired
	public Repository_b(DaoImp dao) {
		this.dao=dao;
	}
	
	//to get all publishers
	public ArrayList<Publisher> getAllPublishers(){
		return (ArrayList<Publisher>) dao.getAllPublishers();
		
	}
	
	public void delPublisher(int id) {
		dao.delPublisher(id);
	}
	
	public void addPublisher(Publisher obj) {
		dao.addPublisher(obj);
	}
	
	public ArrayList<Books> showBooks(int id)
	{
		return dao.showBooks(id);
		
	}
	
	
	//to get all publishers
		public ArrayList<Books> getAllBooks(){
			return (ArrayList<Books>) dao.getAllBooks();
			
		}
		
}
