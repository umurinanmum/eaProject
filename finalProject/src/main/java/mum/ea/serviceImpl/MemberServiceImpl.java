package mum.ea.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.ea.dao.MemberDao;
import mum.ea.domain.Course;
import mum.ea.domain.Member;
import mum.ea.service.MemberService;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {
    
	@Autowired 
	MemberDao memberDao;
	
	public void save(Member t) {
		memberDao.save(t);

	}

	public void delete(Long id) {
		memberDao.delete(id);

	}

	public void update(Member t) {
		memberDao.update(t);
	}

	public Member findById(Long id) {
		
		return memberDao.findById(id);
	}

	public List<Member> findAll() {
		
		return memberDao.findAll();
	}

	
	@Override
	public List<Member> findByMemberType(String memberType) {
		// TODO Auto-generated method stub
		return memberDao.findByMemberType(memberType);
	}

	

	@Override
	public List<Course> searchCourses(long id, String coursename) {
		
     return memberDao.searchCourses(id, coursename);
		
	}

	@Override
	public List<Course> myCourses(long id) {
		
		return memberDao.myCourses(id);
	}

	@Override
	public List<Course> myArchiveCourses(long id) {
		
		return memberDao.myArchiveCourses(id);
	}
	
	@Override
	public List<Course> myInProgressCourses(long id) {
		
		return memberDao.myInProgressCourses(id);
	}

	@Override
	public Member findByUserName(String username) {
		
		return memberDao.findByUserName(username);
	}

}
