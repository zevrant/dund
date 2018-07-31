package com.dnd.resources.dundresourceorganizer.dto;

import java.util.List;

public class HighLevelEntryDTO {

    private String type;
    private String name;
    private List<String> entries;

    public HighLevelEntryDTO() {
    }

    public HighLevelEntryDTO(String type, String name, List<String> entries) {
        this.type = type;
        this.name = name;
        this.entries = entries;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getEntries() {
        return entries;
    }

    public void setEntries(List<String> entries) {
        this.entries = entries;
    }
}
