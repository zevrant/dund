package com.dnd.resources.dundresourceorganizer.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "durations", schema = "dund")
public class Duration {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "durationSequence")
    @SequenceGenerator(name = "durationSequence", sequenceName = "duration_sequence", schema = "dund", initialValue = 10, allocationSize=99999999)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "duration_type")
    private String type;

    @Column(name = "condition")
    private String condition;

    @ManyToMany(targetEntity = EndCondition.class, fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "DURATION_END_JOIN", joinColumns = {
            @JoinColumn(name = "end_condition_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "duration_id",
                    nullable = false) })
    private List<EndCondition> ends;

    @Column(name = "concentration")
    private boolean concentration;

    @Column(name = "sub_type")
    private String subType;

    @Column(name = "amount")
    private int amount;

    @Column(name = "up_to")
    private boolean upTo;

    public Duration() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public List<EndCondition> getEnds() {
        return ends;
    }

    public void setEnds(List<EndCondition> ends) {
        this.ends = ends;
    }

    public boolean isConcentration() {
        return concentration;
    }

    public void setConcentration(boolean concentration) {
        this.concentration = concentration;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isUpTo() {
        return upTo;
    }

    public void setUpTo(boolean upTo) {
        this.upTo = upTo;
    }
}
