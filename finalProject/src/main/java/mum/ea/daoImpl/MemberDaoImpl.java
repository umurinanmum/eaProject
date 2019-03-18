package mum.ea.daoImpl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import mum.ea.dao.MemberDao;
import mum.ea.dao.abstracts.GenericDaoImpl;
import mum.ea.domain.Course;
import mum.ea.domain.Member;

@Repository
public class MemberDaoImpl extends GenericDaoImpl<Member> implements MemberDao{
   
	public MemberDaoImpl() {
        super.domainClass = Member.class;
    }
	@Override
	public List<Member> findByMemberType(String memberType) {
		Query query=entityManager.createQuery("SELECT m from Member m where m.memberType.type=:memberType");
		return (List<Member>)query.setParameter("memberType", memberType).getResultList();
	}
	@Override
	public List<Course> searchCourses(long id, String coursename) {
		Query query=entityManager.createQuery("SELECT m from Member m, Course c where c not member of m.courseList and m.id=:id and c.name=:coursename");
		List<Course> courses=query.setParameter("id", id).setParameter("coursename", coursename).getResultList();
		return courses;
	}
	@Override
	public List<Course> myCourses(long id) {
		Query query=entityManager.createQuery("SELECT m from Member m where m.id=:id ");
		Member result=(Member) query.setParameter("id", id).getSingleResult();
		
		 List<Course> courses=result.getCourseList();
		 
		return courses;

	}
	@Override
	public List<Course> myArchiveCourses(long id) {
		Query query=entityManager.createQuery("SELECT m from Member m, Course c where m.id=:id and c member of m.courseList and c.status=1  ");
		Member result=(Member) query.setParameter("id", id).getSingleResult();
		
		 List<Course> courses=result.getCourseList();
		return courses;
	}
	
	@Override
	public List<Course> myInProgressCourses(long id) {
		Query query=entityManager.createQuery("SELECT m from Member m, Course c where m.id=:id and c member of m.courseList and c.status=0  ");
		Member result=(Member) query.setParameter("id", id).getSingleResult();
		
		 List<Course> courses=result.getCourseList();
		return courses;
	}
	@Override
	public Member findByUserName(String username) {
		Query query=entityManager.createQuery("SELECT m from Member m where m.firstName=:username");
		Member result=(Member) query.setParameter("username", username).getSingleResult();
		
		return result;
	}

}
