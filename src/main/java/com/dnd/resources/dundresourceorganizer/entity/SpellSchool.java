package com.dnd.resources.dundresourceorganizer.entity;

import javax.persistence.*;

@Entity
@Table(name = "SPELL_SCHOOL", schema = "dund")
public class SpellSchool {


    @Id
    @Column(unique = true, nullable = false, name = "SPELL_SCHOOL")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    public SpellSchool() {
        //no-args
    }

    public SpellSchool(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }
}
