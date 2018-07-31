package com.dnd.resources.dundresourceorganizer.entity;

import com.dnd.resources.dundresourceorganizer.entity.Spell;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "spell_component", schema = "dund")
public class SpellComponent {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "spellComponentSequence")
    @SequenceGenerator(name = "spellComponentSequence", sequenceName = "spell_component_sequence", schema = "dund", initialValue = 10, allocationSize=99999999)
    @Column(name = "id", nullable = false)
    private long id;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "components")
    private List<Spell> spells;

    @Column(name = "component", nullable = false)
    private String component;

    public SpellComponent() {
    }

    public List<Spell> getSpells() {
        return spells;
    }

    public void setSpells(List<Spell> spells) {
        this.spells = spells;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }
}
