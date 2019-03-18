package mum.ea.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import mum.ea.domain.Member;
import mum.ea.service.MemberService;

@Controller
@RequestMapping("/member")
public class LoginController {
	@Autowired 
	MemberService memberService;
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@Valid @ModelAttribute("user") Member member, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			return "login";
		}
		else {
	    Member memberInfo=memberService.findByUserName(member.getUsername());
	    
	       if(memberInfo==null) {
	    	return "login";
	         }
	       else {
	    	   model.addAttribute("member",memberInfo);
	    	   
	    	   return"redirect:/members";
	       }
		}
	    
	}
	
	@RequestMapping(value="/signUp", method=RequestMethod.GET)
	public String signUp(@ModelAttribute("newMember") Member member) {
		
		return "signup";
	}
	
	@RequestMapping(value="/signUp", method=RequestMethod.POST)
	public String signUp(@Valid @ModelAttribute("newMember")Member member, BindingResult result) {
		
		if(result.hasErrors()) {
			
			return "signup";
		}
		System.out.println(member.getUsername());
		memberService.save(member);
		
		return "redirect:/welcome";
	}

}
