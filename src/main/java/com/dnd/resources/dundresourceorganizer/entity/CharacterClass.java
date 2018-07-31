package com.dnd.resources.dundresourceorganizer.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "character_class", schema = "dund")
public class CharacterClass {

    @Id
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "source", nullable = false)
    private String source;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subclassName")
    private List<Subclass> subclass;

    public CharacterClass() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public List<Subclass> getSubclass() {
        return subclass;
    }

    public void setSubclass(List<Subclass> subclass) {
        this.subclass = subclass;
    }
}
