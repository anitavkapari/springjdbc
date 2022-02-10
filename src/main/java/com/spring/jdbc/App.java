package com.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entity.Student;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "My jdbc program started...." );
		//spring jdbc=> JdbcTamplate
       ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/configStud.xml");
      StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
      Student student = new Student();
      //INSERT
//      student.setId(99);
//      student.setName("Dev");
//      student.setCity("patna");
//      int result = studentDao.insert(student);
//      System.out.println("stufdent add " + result);
      
      //UPDATE
//    student.setId(99);
//    student.setName("Avi");
//    student.setCity("Delhi");
//    int result = studentDao.update(student);
//    System.out.println("student update " + result);
//    
    //DELETE
//    int result = studentDao.delete(11);
//    System.out.println("student delete " + result);
      
      //view single record
      student = studentDao.getStudent(22);
      System.out.println("all  " + student);
      
       //view all record
      List<Student>  students = studentDao.getAllStudents();
      for(Student s : students) {
    	  System.out.println(s);
      }
    }
}
