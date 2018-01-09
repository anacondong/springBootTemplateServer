/**
 * 
 */
package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.dao.PersonDao;

/**
 * @author Ittipol
 *
 */
@Controller
public class PersonMvcController {
	@Autowired PersonDao repo;
	
	@RequestMapping("/personHome.php")
	public String personHome(Model model){
		model.addAttribute("persons",repo.findAll());
		return "personHome";
	}
}
