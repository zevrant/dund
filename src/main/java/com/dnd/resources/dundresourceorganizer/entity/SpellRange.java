package com.dnd.resources.dundresourceorganizer.entity;


import javax.persistence.*;

@Entity
@Table(name = "spell_range", schema = "dund")
public class SpellRange {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rangeSequence")
    @SequenceGenerator(name = "rangeSequence", sequenceName = "range_sequence", schema = "dund", initialValue = 10, allocationSize=99999999)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "type")
    private String type;

    @OneToOne
    @JoinColumn(name = "distance")
    private Distance distance;

    public SpellRange() {
    }

    public SpellRange(String type, Distance distance) {
        this.type = type;
        this.distance = distance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Distance getDistance() {
        return distance;
    }

    public void setDistance(Distance distance) {
        this.distance = distance;
    }
}
