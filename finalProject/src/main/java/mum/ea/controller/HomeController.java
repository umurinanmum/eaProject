package mum.ea.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping({"/","/welcome"})

	public String getAll(Model model) {
		
		model.addAttribute("welcome","Welcome to our site");
		
		return "welcome";
		
	}

}
