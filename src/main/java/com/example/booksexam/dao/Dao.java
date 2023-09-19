package com.example.booksexam.dao;

import java.util.ArrayList;

import com.example.booksexam.models.Books;
import com.example.booksexam.models.Publisher;

public interface Dao {
		
		public ArrayList<Publisher> getAllPublishers();
		
		public void delPublisher(int id);
		
		public void addPublisher(Publisher obj);
		
		public ArrayList<Books> showBooks(int id);

		ArrayList<Books> getAllBooks();

	}


