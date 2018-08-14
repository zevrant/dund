package com.dnd.resources.dundresourceorganizer.dto.spellImport;

import java.util.List;

public class DurationTypeDTO {
    private String type;
    private String condition;
    private List<String> ends;
    private DurationDTO duration;
    private boolean concentration;

    public DurationTypeDTO() {
    }

    public DurationTypeDTO(String type, String condition, List<String> ends, DurationDTO duration, boolean concentration) {
        this.type = type;
        this.condition = condition;
        this.duration = duration;
        this.concentration = concentration;
        this.ends = ends;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public List<String> getEnds() {
        return ends;
    }

    public void setEnds(List<String> ends) {
        this.ends = ends;
    }

    public DurationDTO getDuration() {
        return duration;
    }

    public void setDuration(DurationDTO duration) {
        this.duration = duration;
    }

    public boolean isConcentration() {
        return concentration;
    }

    public void setConcentration(boolean concentration) {
        this.concentration = concentration;
    }
}
