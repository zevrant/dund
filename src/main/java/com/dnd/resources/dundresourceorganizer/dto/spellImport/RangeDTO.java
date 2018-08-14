package com.dnd.resources.dundresourceorganizer.dto.spellImport;

public class RangeDTO {
    private String type;
    private DistanceDTO distance;

    public RangeDTO() {
    }

    public RangeDTO(String type, DistanceDTO distance) {
        this.type = type;
        this.distance = distance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public DistanceDTO getDistance() {
        return distance;
    }

    public void setDistance(DistanceDTO distance) {
        this.distance = distance;
    }
}
