package com.dnd.resources.dundresourceorganizer.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "end_condition")
public class EndCondition {

    @Id
    @Column(name = "id")
    private long id;

    @ManyToMany(targetEntity = Duration.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "DURATION_END_JOIN", joinColumns = {
            @JoinColumn(name = "duration_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "end_condition_id",
                    nullable = false, updatable = false) })
    private List<Duration> durations;

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

    public List<Duration> getDurations() {
        return durations;
    }

    public void setDurations(List<Duration> durations) {
        this.durations = durations;
    }

    public String getEndCondition() {
        return endCondition;
    }

    public void setEndCondition(String endCondition) {
        this.endCondition = endCondition;
    }
}
