package com.dnd.resources.dundresourceorganizer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SubclassDTO {

    private ClassDTO classes;
    private ClassDTO subclass;

    public SubclassDTO() {
    }

    public SubclassDTO(ClassDTO classes, ClassDTO subclass) {
        this.classes = classes;
        this.subclass = subclass;
    }

    @JsonProperty("class")
    public ClassDTO getClasses() {
        return classes;
    }

    public void setClasses(ClassDTO classes) {
        this.classes = classes;
    }

    public ClassDTO getSubclass() {
        return subclass;
    }

    public void setSubclass(ClassDTO subclass) {
        this.subclass = subclass;
    }
}
