package mum.ea.domain;


import mum.ea.domain.abstracts.BaseDomain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Lesson extends BaseDomain {

    private String name;

    @ManyToOne
    @JoinColumn(name = "id_course")
    private Course course;

    @OneToMany(mappedBy = "lesson")
    private List<Material> materialList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Material> getMaterialList() {
        return materialList;
    }

    public void setMaterialList(List<Material> materialList) {
        this.materialList = materialList;
    }
}
