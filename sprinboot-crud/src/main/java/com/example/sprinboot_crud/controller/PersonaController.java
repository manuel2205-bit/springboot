package com.example.sprinboot_crud.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.sprinboot_crud.model.Persona;
import com.example.sprinboot_crud.service.PersonaService;


@Controller
public class PersonaController {
	
	@Autowired
	private PersonaService personaService;
	
	@GetMapping("/index")
	public String index(Model model) {
		
		List<Persona> personas = personaService.getAll();
	    System.out.println("Personas encontradas: " + personas);
		model.addAttribute("list", personas);
		return "index";
	}
	
	@GetMapping("/save/{id}")
	public String showSave(@PathVariable("id") Long id, Model model) {
		
		if(id != null && id != 0) {
			
			model.addAttribute("persona", personaService.get(id));
		}else {
			model.addAttribute("persona", new Persona());
		}
		
		return "save"; 
	}
	
	@PostMapping("/save/save")
	public String save(Persona persona, Model model) {
		personaService.save(persona);
		return "redirect:/index";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id, Model model) {
		
		personaService.delete(id);
		
		return "redirect:/index"; 
	}
	
	@GetMapping("/test")
	@ResponseBody
	public String test() {
	    return "El controlador está funcionando";
	}
	

}
