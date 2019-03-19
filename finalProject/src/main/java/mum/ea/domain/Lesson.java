package mum.ea.domain;
 
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.NotEmpty;

import mum.ea.domain.abstracts.BaseDomain;

import java.util.Date;
import java.util.List;

@Entity
public class Lesson extends BaseDomain{

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "LESSON_ID")
    private Long id = null;
	 
	@Version
	@Column(name = "OBJ_VERSION")
	private int version = 0;
	 
	@Column(name = "LESSON_NAME", length = 255, nullable = false)
	@NotEmpty
    private String name;

	@JsonIgnore
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "COURSE_ID")
    @NotNull
    @Valid
    private Course course;
    
    @NotEmpty
    @Column(name = "DESCRIPTION", nullable = false)
    private String description;
       
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="CREATED", nullable = false, updatable = false)
    private Date created;
   
    @Valid
    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(mappedBy = "lesson",fetch=FetchType.EAGER,cascade=CascadeType.ALL)    
    private List<Material> materialList;        

    public Lesson(String name, Course course) {
		super();
		this.name = name;
		this.course = course;
	}

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

   public void addMaterial(Material e) {
	   materialList.add(e);
   }
   
   public void removeMaterial(String materialID) {
	   for(Material e : materialList) {
		   if(true)
			   materialList.remove(e);break;
	   }
   }

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}   
	   
}
