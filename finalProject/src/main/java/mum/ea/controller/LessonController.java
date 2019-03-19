package mum.ea.controller;
 
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import mum.ea.domain.Lesson;
import mum.ea.service.LessonService; 

@RestController
@RequestMapping("/courses/{cid}/lessons")
public class LessonController {
	
	@Autowired	
	LessonService lessonService;
 
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void processAddNewLesson(@RequestBody @Valid Lesson lessonToBeAdded) {
		lessonService.save(lessonToBeAdded);
 
	}
	
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void processUpdateLesson(@RequestBody @Valid Lesson lessonToBeUpdated) {
		lessonService.update(lessonToBeUpdated);
 
	}
	
	@RequestMapping(value = "/{lid}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void processDeleteLesson(@PathVariable("lid") Long lessonID) {
		lessonService.delete(lessonID);
 
	}
	
	@RequestMapping(value = "/{lid}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public Lesson processGetLesson(@PathVariable("lid") Long lessonID) {
		return lessonService.get(lessonID);
 
	}

}
