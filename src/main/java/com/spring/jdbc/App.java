package com.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "My jdbc program started...." );
		//spring jdbc=> JdbcTamplate
       ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/configStud.xml");
       JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);
      
       //insert query
       String data = "insert into student(id,name,city) values(?,?,?)";
      
       //fire query
       int info = template.update(data,100,"Anita","bihar");
       System.out.println( "My jdbc template ...." + info);

    }
}
