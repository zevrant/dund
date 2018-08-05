package com.dnd.resources.dundresourceorganizer.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SPELL", schema = "dund")
public class Spell {

    @Id
    @SequenceGenerator(name = "spell_sequence", sequenceName = "spell_sequence", schema = "dund", initialValue = 10, allocationSize=99999999)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "spell_sequence")
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "name", nullable = false, length = 256)
    private String name;

    @ManyToOne(targetEntity = CastingTime.class)
    @JoinColumn(name = "casting_time", nullable = false)
    private CastingTime castingTime;

    @ManyToMany(targetEntity = SpellComponent.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "component_spell_join", joinColumns = {
            @JoinColumn(name = "spell_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "component_id",
                    nullable = false, updatable = false) })
    private List<SpellComponent> components;

    @Column(name = "descript", nullable = false)
    private String description;

    @ManyToOne(targetEntity = Duration.class)
    @JoinColumn(name = "spell_duration", nullable = false)
    private Duration duration;

    @Column(name = "spell_level", nullable = false)
    private short level;

    @OneToOne
    @JoinColumn(name = "range_id", nullable = false)
    private SpellRange range;

    @Column(name = "school", nullable = false)
    private String school;

    @ManyToMany(targetEntity = CharacterClass.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "spell_class_join", joinColumns = {
            @JoinColumn(name = "spell_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "name",
                    nullable = false, updatable = false) }, schema = "dund")
    private List<CharacterClass> classes;

    @Column(name = "source")
    private String source;

    @Column(name = "ritual")
    private String ritual;

    @Column(name = "technomagic")
    private boolean technomagic;

    public Spell() {
        //no-args
    }

    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public List<SpellComponent> getComponents() {
        return components;
    }


    public void setComponents(List<SpellComponent> components) {
        this.components = components;
    }

    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public CastingTime getCastingTime() {
        return castingTime;
    }


    public void setCastingTime(CastingTime castingTime) {
        this.castingTime = castingTime;
    }

    public Duration getDuration() {
        return duration;
    }


    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public short getLevel() {
        return level;
    }


    public void setLevel(short level) {
        this.level = level;
    }

    public String getSchool() {
        return school;
    }


    public void setSchool(String school) {
        this.school = school;
    }

    public SpellRange getRange() {
        return range;
    }

    public void setRange(SpellRange spellRange) {
        this.range = spellRange;
    }

    public List<CharacterClass> getClasses() {
        return classes;
    }

    public void setClasses(List<CharacterClass> classes) {
        this.classes = classes;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
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
