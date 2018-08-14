package com.dnd.resources.dundresourceorganizer.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "end_condition")
public class EndCondition {

    @Id
    @SequenceGenerator(name = "end_condition_sequence", sequenceName = "end_condition_sequence", schema = "dund", initialValue = 10, allocationSize=99999999)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "end_condition_sequence")
    @Column(name = "id")
    private long id;

    @Column(name = "endCondition")
    private String endCondition;

    public EndCondition() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEndCondition() {
        return endCondition;
    }

    public void setEndCondition(String endCondition) {
        this.endCondition = endCondition;
    }
}
