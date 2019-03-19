package mum.ea.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import mum.ea.domain.Member;
import mum.ea.domain.MemberType;
import mum.ea.domain.Profile;
import mum.ea.serviceImpl.MemberServiceImpl;

public class main_murdock {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
		// TODO Auto-generated method stub
		System.out.println("........TEST.....");
		List<Member> members = new ArrayList();
//		
		MemberServiceImpl mser=new MemberServiceImpl();
		Member testMember = new Member() ;
		testMember.setFirstname("Murdock");
		testMember.setLastname("Bernal");
		testMember.setUsername("Murdock");
		testMember.setPassword("Bernal");	
		//EB create a member for the test
		MemberType mt=new MemberType();
		mt.setType("USER");
		testMember.setMemberType(mt);
		//EB Create a profile for the test
		Profile prof = new Profile();
		prof.setPicName("asdf");
		testMember.setProfile(prof);
		mser.save( testMember);
		members = mser.findAll();
		members.forEach(e->System.out.println(e.getId()+"_"+e.getFirstname()+"_"+e.getLastname() ) );
			
		
		
	}

}
