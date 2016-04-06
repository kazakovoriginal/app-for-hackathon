package com.novoda;

import java.util.ArrayList;

public class ActivityCrit {

    private int id;
    private String name;
    private int typeId;
    ArrayList<Integer> seasid;

    public ActivityCrit(int id, String name, int typeId, ArrayList<Integer> seasid) {
        this.id = id;
        this.name = name;
        this.typeId = typeId;
        this.seasid = seasid;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getTypeId() {
        return typeId;
    }

    public ArrayList<Integer> getSeasid() {
        return seasid;
    }
}



