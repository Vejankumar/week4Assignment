package com.example.demo;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@EnableEurekaClient
@RestController
public class W4AssesmentEurekaServiceCheckloginApplication {

	public static void main(String[] args) {
		SpringApplication.run(W4AssesmentEurekaServiceCheckloginApplication.class, args);
	}
	
	@RequestMapping
	public String verify(@RequestBody User user)
	{
		String id = user.getId();
		String psd = user.getPswd();
		System.out.println("Welcome");
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Sapient123");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from logincheck");
			while(rs.next())
			{
				if(rs.getString(1).equals(id) && rs.getString(2).equals(psd))
					return "correct";
			}
			 return "error";
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			return "error";
		}
		
	}
}
