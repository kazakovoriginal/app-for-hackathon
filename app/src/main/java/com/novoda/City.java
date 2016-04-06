package com.novoda;
import java.util.ArrayList;

public class City  {

    private int countryId;
    private int id;
    private double latitude;
    private double longtitude;
    private String name;
    private ArrayList<Integer> summer;
    private ArrayList<Integer> winter;
    private ArrayList<Integer> other;
    private String description;

    public City(int id, int countryId, String name, double latitude,
                double longtitude, ArrayList<Integer> summer, ArrayList<Integer> winter, ArrayList<Integer> other, String description) {
        this.countryId = countryId;
        this.id = id;
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.name = name;
        this.summer = summer;
        this.winter = winter;
        this.other = other;
        this.description = description;
    }

    public int getCountryId() {
        return countryId;
    }

    public int getId() {
        return id;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongtitude() {
        return longtitude;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Integer> getSummer() {
        return summer;
    }

    public ArrayList<Integer> getWinter() {
        return winter;
    }

    public ArrayList<Integer> getOther() {
        return other;
    }

    public String getDescription() {
        return description;
    }
}
