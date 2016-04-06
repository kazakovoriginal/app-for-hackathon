package com.novoda;
public class Season {

    private int id;
    private String name;

    public Season(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
