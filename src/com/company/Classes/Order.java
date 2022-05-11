package com.company.Classes;

import java.util.List;

public class Order {
    private static int nr = 0;
    private int orderId;
    private int shopId;
    private String username;
    private Employee employee;
    private List<Jewel> jewels;


    public Order(int orderId, int shopId, String username, Employee employee, List<Jewel> jewels) {
        this.orderId = orderId;
        this.shopId = shopId;
        this.username = username;
        this.employee = employee;
        this.jewels = jewels;
    }

    public int finalPrice(){
        int total = 0;
        for(Jewel jewel:jewels)
        {
            total += jewel.getPrice();
        }
        return total;
    }


    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", shopId=" + shopId +
                ", username='" + username + '\'' +
                ", employee=" + employee +
                ", jewels=" + jewels +
                '}';
    }
}
