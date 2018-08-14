package com.dnd.resources.dundresourceorganizer.dto.spellImport;


import java.util.List;

public class SpellDTO {

    private String name;
    private int level;
    private String school;
    private List<TimeDTO> time;
    private RangeDTO range;
    private ComponentDTO components;
    private List<DurationTypeDTO> duration;
    private ClassesListDTO classes;
    private String source;
    private List<EntryDTO> entries;
    private List<HighLevelEntryDTO> entriesHigherLevel;
    private MetaDTO meta;

    public SpellDTO() {
    }

    public SpellDTO(String name, int level, String school, List<TimeDTO> times, RangeDTO range, ComponentDTO components, List<DurationTypeDTO> duration, ClassesListDTO classes, String source, List<EntryDTO> entries, List<HighLevelEntryDTO> entriesHigherLevel) {
        this.name = name;
        this.level = level;
        this.school = school;
        this.time = times;
        this.range = range;
        this.components = components;
        this.duration = duration;
        this.classes = classes;
        this.source = source;
        this.entries = entries;
        this.entriesHigherLevel = entriesHigherLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public List<TimeDTO> getTime() {
        return time;
    }

    public void setTime(List<TimeDTO> time) {
        this.time = time;
    }

    public RangeDTO getRange() {
        return range;
    }

    public void setRange(RangeDTO range) {
        this.range = range;
    }

    public ComponentDTO getComponents() {
        return components;
    }

    public void setComponents(ComponentDTO components) {
        this.components = components;
    }

    public List<DurationTypeDTO> getDuration() {
        return duration;
    }

    public void setDuration(List<DurationTypeDTO> duration) {
        this.duration = duration;
    }

    public ClassesListDTO getClasses() {
        return classes;
    }

    public void setClasses(ClassesListDTO classes) {
        this.classes = classes;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public List<EntryDTO> getEntries() {
        return entries;
    }

    public void setEntries(List<EntryDTO> entries) {
        this.entries = entries;
    }

    public List<HighLevelEntryDTO> getEntriesHigherLevel() {
        return entriesHigherLevel;
    }

    public void setEntriesHigherLevel(List<HighLevelEntryDTO> entriesHigherLevel) {
        this.entriesHigherLevel = entriesHigherLevel;
    }

    public MetaDTO getMeta() {
        return meta;
    }

    public void setMeta(MetaDTO meta) {
        this.meta = meta;
    }
}
