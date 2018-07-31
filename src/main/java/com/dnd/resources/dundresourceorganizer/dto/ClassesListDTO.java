package com.dnd.resources.dundresourceorganizer.dto;

import java.util.List;

public class ClassesListDTO {

    private List<ClassDTO> fromClassList;
    private List<SubclassDTO> fromSubclass;

    public ClassesListDTO() {
    }

    public ClassesListDTO(List<ClassDTO> fromClassList, List<SubclassDTO> fromSubclass) {
        this.fromClassList = fromClassList;
        this.fromSubclass = fromSubclass;
    }

    public List<ClassDTO> getFromClassList() {
        return fromClassList;
    }

    public void setFromClassList(List<ClassDTO> fromClassList) {
        this.fromClassList = fromClassList;
    }

    public List<SubclassDTO> getFromSubclass() {
        return fromSubclass;
    }

    public void setFromSubclass(List<SubclassDTO> fromSubclass) {
        this.fromSubclass = fromSubclass;
    }
}
