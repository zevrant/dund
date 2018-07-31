package com.dnd.resources.dundresourceorganizer.dto;

import com.dnd.resources.dundresourceorganizer.config.EntryDTODeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

@JsonDeserialize(using = EntryDTODeserializer.class)
public class EntryDTO {
    private String entry;
    private String type;
    private String name;
    private List<String> entries;

    public EntryDTO() {
    }

    public EntryDTO(String entry, String type, String name, List<String> entries) {
        this.entry = entry;
        this.type = type;
        this.name = name;
        this.entries = entries;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
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
