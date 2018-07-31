package com.dnd.resources.dundresourceorganizer.dto;

public class ClassDTO {

    private String name;
    private String source;

    private String subSubclass;

    public ClassDTO() {
    }

    public ClassDTO(String name, String source, String subSubclass) {
        this.name = name;
        this.source = source;
        this.subSubclass = subSubclass;
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

    public String getSubSubclass() {
        return subSubclass;
    }

    public void setSubSubclass(String subSubclass) {
        this.subSubclass = subSubclass;
    }
}
