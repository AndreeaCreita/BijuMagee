package com.company.Classes;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private static int id = 0;
    private int shopId;
    private String name;
    private String address;
    private List<Jewel> shop;
    private List<Client> clients;


    public Shop(String name, String address) {
        this.shopId = id;
        id++;
        this.name = name;
        this.address = address;
        this.shop =  new ArrayList<>();
        this.clients =  new ArrayList<>();
    }


    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Shop.id = id;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Jewel> getShop() {
        return shop;
    }

    public void setShop(List<Jewel> shop) {
        this.shop = shop;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }


    public void AddRing(String name, int price, int weight, List<String> elements) {
        Jewel jewel = new Ring(name, price, this, weight, elements);
        shop.add(jewel);
    }

    public void AddNecklace(String name, int price, int chainLength) {
        Jewel jewel = new Necklace(name, price, this, chainLength);

        shop.add(jewel);
    }

    public void DisplayShopMenu() {
        System.out.println("The shop has the following items: ");
        for (Jewel jewel:shop) {
            jewel.Print();
        }
    }

//    public Jewel BuyProduct(String name) {
//        for(Jewel jewel:shop) {
//            if(jewel.getName().equals(name)) {
//                return jewel;
//            }
//        }
//        return null;
//    }

//    public void AddClient(String name, String username, String password) {
//        Client client;
//        client = new Client(name, username, password);
//        clients.add(client);
//    }

//    public void DisplayClients(){
//        for (Client client : clients){
//            client.DisplayClient();
//        }
//    }

    public void DisplayShop() {
        System.out.println("The shop " + name + " with id " + shopId);
    }

    @Override
    public String toString() {
        return "Shop{" +
                "shopId=" + shopId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", shop=" + shop +
                ", clients=" + clients +
                '}';
    }
}

