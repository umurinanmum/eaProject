package mum.ea.domain;

import mum.ea.domain.abstracts.BaseDomain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Member extends BaseDomain {

    private String firstname;
    private String lastname;
    private String username;
    private String password;


    @OneToOne
    @JoinColumn(name = "id_member_type")
    private MemberType memberType;

    @ManyToMany(mappedBy = "joinedMembers")
    private List<Course> courseList;

    @OneToMany(mappedBy = "instructor")
    private List<Course> teachingCourseList;

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
}
