package com.company.Classes;

public class Necklace extends Jewel{
    int chainLength;

    public Necklace(String name, int price, Shop shop, int chainLength) {
        super(name, price, shop);
        this.chainLength = chainLength;
    }

    @Override
    public void Print() {
        super.Print();
        System.out.println("The necklace chain is " + chainLength + " cm");
    }

    @Override
    public String toString() {
        return "Necklace{" +
                "chainLength=" + chainLength +

                "name" + name +
        '}';
    }
}
