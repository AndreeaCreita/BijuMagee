package com.company.Service;

import com.company.Classes.*;
import com.company.Service.csv.NecklaceCSV;
import com.company.Service.csv.RingCSV;
import com.company.Service.csv.ShopCSV;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShopService {

    private static HashMap<String, Shop> shops;
    private ArrayList<Ring> ring = new ArrayList<>();
    private ArrayList<Necklace> necklace = new ArrayList<>();
    private final RingCSV ringCSV = RingCSV.getInstance();
    private List<Employee> employees;


    public ShopService() throws FileNotFoundException {
        shops = new HashMap<>();
        ring.addAll(RingCSV.getInstance().load("./csv/ring.csv"));
        necklace.addAll(NecklaceCSV.getInstance().load("./csv/necklace.csv"));
        for(Shop s : ShopCSV.getInstance().load("./csv/shops.csv"))
        {
            shops.put(s.getName() ,s);
        }

    }


    //adaugare magazin
    public void addShop(String name, String address) {
        Shop s = new Shop(name, address);
        shops.put(name, s);
        ShopCSV.getInstance().add("./csv/shops.csv", s);
    }

    //adaugare inel

    public void addRing(String shop, String name,int price, int weight, List<String> elements) {

        Shop s;
        if (shops.containsKey(shop))
            s = shops.get(shop);
        else
        {
            System.out.println("Shop " + shop + " is not available.");
            return;
        }
        s.AddRing(name, price, weight, elements);
        Ring rg = new Ring(name, price, s,weight, elements);
        RingCSV.getInstance().add("./csv/ring.csv",rg);
    }

    //adaugare lant
    public void addNecklace(String shopName, String name, int price, int chainLength){
        Shop s;
        if(shops.containsKey(shopName))
            s = shops.get(shopName);
        else
        {
            System.out.println("Shop " + shopName + "is not available");
            return;
        }
        s.AddNecklace(name, price, chainLength);
        Necklace nl = new Necklace(name, price, s, chainLength);
        NecklaceCSV.getInstance().add("./csv/necklace.csv",nl);
    }

    public void Jewels()
    {
        for (Shop s: shops.values())
        {
            System.out.println("Shop " + s.getName() + " has the following items: ");
            s.DisplayShopMenu();
            System.out.println("\n");
        }
    }


    public void JewelsShop(String shopName)
    {
        Shop s;
        if(shops.containsKey(shopName))
            s = shops.get(shopName);
        else
        {
            System.out.println("The shop " + shopName + " is not available.");
            return;
        }
        s.DisplayShopMenu();
    }

    public static HashMap<String, Shop> getShops()
    {
        return shops;
    }

    public boolean findShop(String name)
    {
        return shops.containsKey(name);
    }

//    private Employee findEmployee(String name) {
//        for (Employee employee : employees) {
//            if (employee.getEmployeeName().equals(name)) {
//                return employee;
//            }
//        }
//        return null;
//    }

}
