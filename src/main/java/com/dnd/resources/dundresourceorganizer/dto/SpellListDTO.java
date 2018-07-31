package com.dnd.resources.dundresourceorganizer.dto;

import com.dnd.resources.dundresourceorganizer.entity.Spell;

import java.util.List;

public class SpellListDTO {

    List<SpellDTO> spell;

    public SpellListDTO() {
    }

    public SpellListDTO(List<SpellDTO> spell) {
        this.spell = spell;
    }

    public List<SpellDTO> getSpells() {
        return spell;
    }

    public void setSpell(List<SpellDTO> spell) {
        this.spell = spell;
    }
}
