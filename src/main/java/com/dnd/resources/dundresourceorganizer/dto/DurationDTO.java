package com.dnd.resources.dundresourceorganizer.dto;

public class DurationDTO {

    private String type;
    private int amount;
    private boolean upTo;

    public DurationDTO() {
    }

    public DurationDTO(String type, int amount, boolean upTo) {
        this.type = type;
        this.amount = amount;
        this.upTo = upTo;
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

    public boolean isUpTo() {
        return upTo;
    }

    public void setUpTo(boolean upTo) {
        this.upTo = upTo;
    }
}
