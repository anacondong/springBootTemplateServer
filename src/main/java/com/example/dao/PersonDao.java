/**
 * 
 */
package com.example.dao;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Person;

/**
 * @author Ittipol
 *
 */
public interface PersonDao extends JpaRepository<Person,Integer>{

		//@org.springframework.data.jpa.repository.Query("....")
		Collection<Person> findByName(String name);
		Collection<Person> findByEmail(String email);
	
}
