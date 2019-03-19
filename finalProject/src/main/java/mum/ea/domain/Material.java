package mum.ea.domain;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty; 

@Entity
public class Material {

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "MATERIAL_ID")
    private Long id = null;
	
	@Column(name = "LESSON_NAME", length = 255, nullable = false)
	@NotEmpty
    private String name;
	
	@NotEmpty
	@Column(name = "DESCRIPTION", length = 1000, nullable = false)
	private String description;
	
	@NotNull
	private String payLoad;

    @JsonIgnore
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "LESSON_ID")
    @NotNull
    @Valid
    private Lesson lesson;       
 
	public Material(String name, String description, String payLoad, Lesson lesson) {
		super();
		this.name = name;
		this.description = description;
		this.payLoad = payLoad;
		this.lesson = lesson;
	}
	
	public String getPayload() {
		return this.payLoad;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Lesson getLesson() {
        return lesson;
    } 

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}
    
}
