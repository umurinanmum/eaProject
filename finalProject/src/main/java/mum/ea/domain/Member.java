package mum.ea.domain;

import mum.ea.domain.abstracts.BaseDomain;

import javax.persistence.*;
import javax.validation.Valid;

import org.codehaus.jackson.annotate.JsonManagedReference;
import org.hibernate.validator.constraints.*;

import java.util.List;

@Entity
public class Member extends BaseDomain {
  
	@NotEmpty(message="")
    private String firstname;
	@NotEmpty(message="")
    private String lastname;
	@NotEmpty
    private String username;
	@NotEmpty
    private String password;
   


    @OneToOne
    @JoinColumn(name = "id_member_type")
    
    @Valid
    private MemberType memberType;

    @ManyToMany(mappedBy = "joinedMembers")
    
    private List<Course> courseList;

    @OneToMany(mappedBy = "instructor")
    private List<Course> teachingCourseList;
    
    
    @OneToOne(mappedBy="member")
    @Valid
    @JsonManagedReference
    private Profile profile;
    
    
	public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public MemberType getMemberType() {
        return memberType;
    }

    public void setMemberType(MemberType memberType) {
        this.memberType = memberType;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public List<Course> getTeachingCourseList() {
        return teachingCourseList;
    }

    public void setTeachingCourseList(List<Course> teachingCourseList) {
        this.teachingCourseList = teachingCourseList;
    }

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}


}
