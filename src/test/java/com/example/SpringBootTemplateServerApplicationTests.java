package com.example;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.dao.PersonDao;
import com.example.entity.Person;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootTemplateServerApplicationTests {

	@Autowired PersonDao repo;
	
	
	@Test
	public void contextLoads() {
		
		// get all persons
		List<Person> listPersons = repo.findAll();
		
		for(Person ps : listPersons){
			System.out.println("Name : "+ps.getName() +">>> Email : "+ps.getEmail());
		}
		
		
	}

}
