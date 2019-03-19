package mum.ea.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.ea.dao.LessonDao; 
import mum.ea.domain.Lesson;
import mum.ea.service.LessonService;

@Service
@Transactional
public class LessonServiceImpl implements LessonService {

	@Autowired 
	LessonDao lessonDao;
	
	@Override
	public void save(Lesson t) {
		// TODO Auto-generated method stub
		lessonDao.save(t);
	}

	@Override
	public void update(Lesson t) {
		// TODO Auto-generated method stub
		lessonDao.update(t);
	}

	@Override
	public void delete(Long id) {
		lessonDao.delete(id);
		
	}

	@Override
	public Lesson get(Long id) {
		// TODO Auto-generated method stub
		return lessonDao.findOne(id);
	} 
}
