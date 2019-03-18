package mum.ea.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import mum.ea.domain.Member;
import mum.ea.service.MemberService;
import mum.ea.utilities.FileUpload;

@Controller
@RequestMapping("/members")
public class MemberController {
	
	@Autowired 
	
	MemberService memberService;
	
	@Autowired 
	
	FileUpload fileUpload;
	
	//get all members
	
	@RequestMapping({"/","/welcome"})

	public String allMembers(Model model) {
		
		model.addAttribute("members",memberService.findAll());
		
		return "welcome";
		
	}
	
	//get all students
	
	@RequestMapping(value="/students", method=RequestMethod.GET)
	
	public String allStudents(Model model) {
		model.addAttribute("students",memberService.findByMemberType("STUDENT"));
		
		return "students";
	}
	
	//get all students
	
		@RequestMapping(value="/teachers", method=RequestMethod.GET)
		
		public String allTeachers(Model model) {
			model.addAttribute("students",memberService.findByMemberType("TEACHER"));
			
			return "teachers";
		}
	
	
	//Get member information into the edit UI 
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public String editMemberInfo(@PathVariable Long id,Model model) {
		
		model.addAttribute("member",memberService.findById(id));
		return "editMemberInfo";
	}
	
	//edit member information 
	@RequestMapping(value="/edit",method=RequestMethod.PUT)
	public String editMemberInfo(@Valid @ModelAttribute("updatedMember") Member member, BindingResult result,Model model) {
		
		if(result.hasErrors()) {
			return "editMemberInfo";
		}
		memberService.update(member);
		
		return"redirect:/members/profile";
	}
	
	//Get memmber picture UI
	@RequestMapping(value="/editPic", method=RequestMethod.GET)
	public String editMemberInfoProfilePic(@PathVariable Long id,Model model,HttpSession session) {
		model.addAttribute("profilePic",fileUpload.getPath(session)+memberService.findById(id).getProfile());
		return "editMemberInfoPic";
	}
	
	//Edit member picture
	@RequestMapping(value="/editPic",method=RequestMethod.PUT)
	public String editMemberInfoProfilePic(@PathVariable("file") MultipartFile file, Model model,HttpSession session) {
		String fileName=fileUpload.fileNameUploaded(session,file);
		 
		 if(fileName==null || fileName==" ") {
			 model.addAttribute("message", "please choose the picture first");
			 return "editMemberInfoPic";
		 }
		 model.addAttribute("message",fileName);
		 return "redirect:/members/meberPic";
	}
	
	
	
	//Search a course a member did not take or scheduled 
	
	@RequestMapping(value="/courses", method=RequestMethod.POST)
	
	public String searchCourses(@PathVariable("coursename") String coursename,BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "noElementFound";
		}
		long id=13213;//get id by session
		model.addAttribute("courses",memberService.searchCourses(id,coursename));
		
		return "searchCourse";
	}
	
	
	
	//Member courses
	
		@RequestMapping(value="/mycourses", method=RequestMethod.GET)
		
		public String myCourses(Model model) {
			
			long id=13213;//get id by session
			model.addAttribute("mycourses",memberService.myCourses(id));
			
			return "myCourses";
		}
		
  //Member archive courses
		
		@RequestMapping(value="/archiveCourses", method=RequestMethod.GET)
		
		public String myArchiveCourses(Model model) {
			long id=13213;//get id by session
			model.addAttribute("mycourses",memberService.myArchiveCourses(id));
			
			
			return "archiveCourses";
			
		}
		
		
		//Member archive courses
		
				@RequestMapping(value="/inProgressCourses", method=RequestMethod.GET)
				
				public String myInProgressCourses(Model model) {
					long id=13213;//get id by session
					model.addAttribute("courses",memberService.myInProgressCourses(id));
					
					
					return "inProgressCourses";
					
				}
		
		
	
	
	
	
	


}
