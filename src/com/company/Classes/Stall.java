package com.company.Classes;

public class Stall {
    private String location;
    private String name;

    public Stall(String location, String name) {
        this.location = location;
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void DisplayStall(){
        System.out.println("The stall " + name + " with location " + location);
    }
}
