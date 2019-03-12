package mum.ea.domain;

import mum.ea.domain.abstracts.BaseDomain;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Category extends BaseDomain {

    private String name;

    @OneToMany(mappedBy = "category")
    private List<SubCategory> subCategoryList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubCategory> getSubCategoryList() {
        return subCategoryList;
    }

    public void setSubCategoryList(List<SubCategory> subCategoryList) {
        this.subCategoryList = subCategoryList;
    }
}
