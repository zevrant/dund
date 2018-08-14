package com.dnd.resources.dundresourceorganizer.dto.spellImport;

public class ComponentDTO {
    private boolean v;
    private boolean s;
    private String m;

    public ComponentDTO() {
    }

    public ComponentDTO(boolean v, boolean s) {
        this.v = v;
        this.s = s;
    }

    public ComponentDTO(boolean v, boolean s, String m) {
        this.v = v;
        this.s = s;
        this.m = m;
    }

    public boolean isV() {
        return v;
    }

    public void setV(boolean v) {
        this.v = v;
    }

    public boolean isS() {
        return s;
    }

    public void setS(boolean s) {
        this.s = s;
    }

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }
}
