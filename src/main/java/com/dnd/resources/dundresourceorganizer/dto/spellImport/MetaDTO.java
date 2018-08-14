package com.dnd.resources.dundresourceorganizer.dto.spellImport;

public class MetaDTO {

    private String ritual;
    private boolean technomagic;

    public MetaDTO() {
    }

    public MetaDTO(String ritual, boolean technomagic) {
        this.ritual = ritual;
        this.technomagic = technomagic;
    }

    public String getRitual() {
        return ritual;
    }

    public void setRitual(String ritual) {
        this.ritual = ritual;
    }

    public boolean isTechnomagic() {
        return technomagic;
    }

    public void setTechnomagic(boolean technomagic) {
        this.technomagic = technomagic;
    }
}
