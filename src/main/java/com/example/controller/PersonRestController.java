/**
 * 
 */
package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.PersonDao;
import com.example.entity.Person;

/**
 * @author Ittipol
 *
 */
@RestController
@RequestMapping("/persons")
public class PersonRestController {
	@Autowired PersonDao repo;
	@RequestMapping("")
	public List<Person> listPersons(){
		return repo.findAll();
	}
	
	@RequestMapping("/{id}")
	public Person getById(@PathVariable Integer id){
		return repo.findOne(id);
	}
	
	
	
	
	
	
}
