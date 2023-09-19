package com.example.booksexam.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;
import com.example.booksexam.models.Books;
import com.example.booksexam.models.Publisher;
import com.example.booksexam.rowMapper.*;
@Component
public class DaoImp implements Dao {
	
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public DaoImp(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate= jdbcTemplate;
	}

	@Override
	public ArrayList<Publisher> getAllPublishers() {
		String sql="SELECT * FROM likhita_publishers";
				
		return (ArrayList<Publisher>) jdbcTemplate.query(sql, new PublisherMapper());
	}

	//to delete a publisher
	@Override
	public void delPublisher(int id) {
		
		String sql="DELETE FROM likhita_publishers WHERE  publisher_id=?";
		jdbcTemplate.update(sql,id);
	}
	
	//to add new publisher
	@Override
	public void addPublisher(Publisher obj) {
		

		
		    String sql = "INSERT INTO likhita_publishers (publisher_name, location, established_year) VALUES (?, ?, ?)";

		    jdbcTemplate.update(sql, obj.getPublisher_name(), obj.getLocation(), obj.getEstablished_year());
				
	}

	@Override
	public ArrayList<Books> showBooks(int id) {
	    String sql = "SELECT * FROM likhita_books WHERE publisher_id = ?";
	    ArrayList<Books> m= (ArrayList<Books>) jdbcTemplate.query(sql, new Object[]{id}, new BooksMapper());
	    System.out.println(m);
	    return (ArrayList<Books>) jdbcTemplate.query(sql, new Object[]{id}, new BooksMapper());
	}
	
	
	@Override
	public ArrayList<Books> getAllBooks() {
		String sql="SELECT * FROM likhita_books";
				
		return (ArrayList<Books>) jdbcTemplate.query(sql, new BooksMapper());
	}


	

}
