package mum.ea.domain;

import mum.ea.domain.abstracts.BaseDomain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Course extends BaseDomain {

    private String name;

    @OneToMany(mappedBy = "course")
    private List<Lesson> lessonList;


    @ManyToOne
    @JoinColumn(name = "instuctor_id")
    private Member instructor;

    @ManyToMany
    @JoinTable(name = "Enrollment",
            joinColumns = {@JoinColumn(name = "id_course")},
            inverseJoinColumns = {@JoinColumn(name = "id_member")})
    private List<Member> joinedMembers;


    @ManyToOne
    @JoinColumn(name = "id_sub_category")
    private SubCategory subCategory;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Lesson> getLessonList() {
        return lessonList;
    }

    public void setLessonList(List<Lesson> lessonList) {
        this.lessonList = lessonList;
    }

    public Member getInstructor() {
        return instructor;
    }

    public void setInstructor(Member instructor) {
        this.instructor = instructor;
    }

    public List<Member> getJoinedMembers() {
        return joinedMembers;
    }

    public void setJoinedMembers(List<Member> joinedMembers) {
        this.joinedMembers = joinedMembers;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }
}
