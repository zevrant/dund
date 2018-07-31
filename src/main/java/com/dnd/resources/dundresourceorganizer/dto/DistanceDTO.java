package com.dnd.resources.dundresourceorganizer.dto;

public class DistanceDTO {
    private String type;
    private int amount;

    public DistanceDTO() {
    }

    public DistanceDTO(String type, int amount) {
        this.type = type;
        this.amount = amount;
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
