package com.dnd.resources.dundresourceorganizer.entity;

import javax.persistence.*;

@Entity
@Table(name = "distance", schema = "dund")
public class Distance {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "distanceSequence")
    @SequenceGenerator(name = "distanceSequence", sequenceName = "distance_sequence", schema = "dund", initialValue = 10, allocationSize=99999999)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "amount", nullable = false)
    private int amount;

    public Distance() {
    }

    public Distance(String type, int amount) {
        this.type = type;
        this.amount = amount;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
