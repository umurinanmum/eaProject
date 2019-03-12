package mum.ea.domain;

import mum.ea.domain.abstracts.BaseDomain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Material extends BaseDomain {


    private String name;

    @ManyToOne
    @JoinColumn(name = "id_lesson")
    private Lesson lesson;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }
}
