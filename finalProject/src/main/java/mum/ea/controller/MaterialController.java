package mum.ea.controller;
  
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
import org.springframework.web.bind.annotation.ResponseStatus;

import mum.ea.domain.Material;
import mum.ea.service.MaterialService;
 

@Controller
@RequestMapping("/courses/{cid}/lessons/{lid}/materials")
public class MaterialController {
	 @Autowired
	 MaterialService materialService;
  

	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void processAddNewLesson(@RequestBody @Valid Material materialToBeAdded) {
		materialService.save(materialToBeAdded);

	}
	
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void processUpdateLesson(@RequestBody @Valid Material materialToBeUpdated) {
		materialService.update(materialToBeUpdated);

	}
	
	@RequestMapping(value = "/{lid}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void processDeleteLesson(@PathVariable("mid") Long materialID) {
		materialService.delete(materialID);

	}
	
	@RequestMapping(value = "/{lid}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public Material processGetLesson(@PathVariable("mid") Long materialID) {
		return materialService.get(materialID);

	}
 
 /*
 @Autowired
 FileUpload fileUpload;
 
 @RequestMapping(value="/upload", method=RequestMethod.GET)
 
 public String addMaterial(@ModelAttribute("newMaterial") Material material) {
	return "addMaterial";
	 
 }
 
 @RequestMapping(value="/{file}", method=RequestMethod.POST)
 
 public String addMaterial(@PathVariable("file") MultipartFile file, Model model,HttpSession session) {
      
	 String fileName=fileUpload.fileNameUploaded(session,file);
	 
	 if(fileName==null || fileName==" ") {
		 model.addAttribute("message", "please choose the file first");
		 return "addMaterial";
	 }
	 model.addAttribute("message",fileName);
	 return "redirect:/materials/uploadStatus";
 }
 
 @RequestMapping(value="/")
 
 public String uploadStatus() {
	 
	 return "uploadStatus";
 }*/

}
