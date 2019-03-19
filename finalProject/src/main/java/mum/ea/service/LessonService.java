package mum.ea.service;
 
import mum.ea.domain.Lesson; 

public interface LessonService {

	public void save(Lesson lesson);
	public void update(Lesson lesson); 
	public void delete(Long lessonID);
	public Lesson get(Long lessonID);
	 
}
