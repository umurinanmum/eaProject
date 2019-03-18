package mum.ea.service;

import java.util.List;

import mum.ea.domain.Course;
import mum.ea.domain.Member;
import mum.ea.service.abstracts.EaCrudService;

public interface MemberService extends EaCrudService<Member> {


	List<Course> searchCourses(long id, String coursename);
	List<Member> findByMemberType(String memberType);
	List<Course> myCourses(long id);
	List<Course> myArchiveCourses(long id);
	List<Course> myInProgressCourses(long id);
	Member findByUserName(String username);


}
