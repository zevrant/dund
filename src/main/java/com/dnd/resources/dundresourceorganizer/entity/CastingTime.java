package com.dnd.resources.dundresourceorganizer.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "casting_time", schema = "dund")
public class CastingTime {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "time_sequence")
    @SequenceGenerator(name = "time_sequence", sequenceName = "time_sequence", schema = "dund", initialValue = 10, allocationSize=99999999)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "numeral")
    private String number;

    @Column(name = "unit")
    private String unit;

    @Column(name = "condition")
    private String condition;

    public CastingTime() {
    }

    public CastingTime(String number, String unit, String condition) {
        this.number = number;
        this.unit = unit;
        this.condition = condition;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
