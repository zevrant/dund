package com.dnd.resources.dundresourceorganizer.dto;

public class TimeDTO {

    private String number;
    private String unit;
    private String condition;

    public TimeDTO() {

    }

    public TimeDTO(String number, String unit, String condition) {
        this.number = number;
        this.unit = unit;
        this.condition = condition;
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
