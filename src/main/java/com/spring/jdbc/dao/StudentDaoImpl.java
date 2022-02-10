package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entity.Student;

public class StudentDaoImpl implements StudentDao{
	
	private JdbcTemplate jdbcTemplate;
	public int insert(Student student) {
		 //insert query
	       String query = "insert into student(id,name,city) values(?,?,?)";
	       int data = this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
	       return data;
	}

	public int update(Student student) {
		//update query
	    String query = "update student set name=? , city=? where id=?";
	    int data = this.jdbcTemplate.update(query, student.getName(),student.getCity(),student.getId()); 
		return data;
	}

	public int delete(int  studentid) {
		//delete query
		 String query = "delete from student where id=?";
		 int data = this.jdbcTemplate.update(query, studentid); 
		 return data;
	}
	
	public Student getStudent(int studentId) {
	    String query = "select * from student where id=?";
	    RowMapper<Student> rowMapper =new RowMapperImpl();
	    Student student = this.jdbcTemplate.queryForObject(query, rowMapper,studentId);
		return student;
	}
	
	public List<Student> getAllStudents() {
		
	    String query = "select * from student";
	    List<Student> students = this.jdbcTemplate.query(query,new RowMapperImpl());
		return students;
	}


	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	
	
	
}