package mum.ea.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mum.ea.controller.abstracts.CrudController;
import mum.ea.domain.Course;
import mum.ea.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController extends CrudController<Course,CourseService> {
    @Autowired
    CourseService courseService;
//part to do
   

}
