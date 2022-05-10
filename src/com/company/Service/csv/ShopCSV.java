package com.company.Service.csv;

import com.company.Classes.Shop;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class ShopCSV implements SingletonCSV<Shop>{

    private static final ShopCSV INSTANCE = new ShopCSV();

    private final String auditPath = "./csv/audit.csv";

    private ShopCSV(){}

    @Override
    public ArrayList<Shop> load(String fileName) throws FileNotFoundException {
        BufferedReader csvReader = new BufferedReader(new FileReader(fileName));
        ArrayList<Shop> shops = new ArrayList<Shop>();
        try {
            String line = csvReader.readLine();
            while (line != null)
            {
                String[] data = line.split(",");
                Shop shop = new Shop(data[0], data[1]);
                shops.add(shop);
                line = csvReader.readLine();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        audit(auditPath, "add-shop");
        return shops;
    }


    @Override
    public void add(String fileName, Shop content) {
        FileWriter csvWriter = null;
        try {
            csvWriter = new FileWriter(fileName, true);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        try {
            csvWriter.append(content.toString());
            csvWriter.append("\n");
            csvWriter.flush();
            csvWriter.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        audit(auditPath, "Shops added");
    }

    public static ShopCSV getInstance() {
        return INSTANCE;
    }
}
