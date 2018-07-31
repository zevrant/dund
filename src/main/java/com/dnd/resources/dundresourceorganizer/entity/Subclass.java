package com.dnd.resources.dundresourceorganizer.entity;

import javax.persistence.*;

@Entity
@Table(name = "sub_class")
public class Subclass {

    @ManyToOne(targetEntity = CharacterClass.class, optional = false)
    private CharacterClass characterClass;

    @Id
    @Column(name = "name")
    private String subclassName;

    @Column(name = "source")
    private String source;

    @Column(name = "sub_sub_class")
    private String subSubClass;

    public Subclass() {
    }

    public CharacterClass getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(CharacterClass characterClass) {
        this.characterClass = characterClass;
    }

    public String getSubclassName() {
        return subclassName;
    }

    public void setSubclassName(String subclassName) {
        this.subclassName = subclassName;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSubSubClass() {
        return subSubClass;
    }

    public void setSubSubClass(String subSubClass) {
        this.subSubClass = subSubClass;
    }
}
