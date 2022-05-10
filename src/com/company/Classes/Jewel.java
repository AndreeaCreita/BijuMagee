package com.company.Classes;

public class Jewel{

    protected String name;
    protected int price;
    protected Shop shop;

    public Jewel(String name, int price, Shop shop) {
        this.name = name;
        this.price = price;
        this.shop = shop;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public void Print() {
        System.out.println("The jewel " + name + " is  " + price + "$");
    }
}
