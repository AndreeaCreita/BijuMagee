package com.company.Classes;

public class Client {
    private String name;
    private String username;
    private String password;
    //private int nrOrders;

    public Client(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
        //this.nrOrders = nrOrders;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public void DisplayClient(){
        System.out.println("The client " + name + "with username " + username );
    }

}