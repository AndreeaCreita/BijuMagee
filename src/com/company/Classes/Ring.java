package com.company.Classes;

import java.util.ArrayList;
import java.util.List;

public class Ring extends Jewel{

    private int weight;
    private List<String> elements;

    public Ring(String name, int price, Shop shop, int weight, List<String> elements) {
        super(name, price, shop);
        this.weight = weight;
        this.elements = new ArrayList<>(elements);
    }

    @Override
    public void Print() {
        super.Print();

        System.out.println("The ring with weight " + weight + " is made of: ");
        for(String elem:elements) {
            System.out.println(elem);
            System.out.println(" ");
        }
        System.out.println("\n");
    }
}
