package mum.ea.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mum.ea.domain.Material;
import mum.ea.service.MaterialService;
import mum.ea.utilities.FileUpload;

@Controller
@RequestMapping("materials")
public class MaterialController {
 @Autowired
 MaterialService materialService;
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
 }

}
