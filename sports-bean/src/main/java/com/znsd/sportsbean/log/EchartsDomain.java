package com.znsd.sportsbean.log;

public class EchartsDomain {
    private String name;
    private Integer value;

    public EchartsDomain() {
        super();
    }

    public EchartsDomain(String name, Integer value) {
        super();
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
