package com.company.Service.csv;

import com.company.Classes.Jewel;
import com.company.Classes.Shop;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JewelCSV implements SingletonCSV<Jewel> {

    private static final JewelCSV INSTANCE = new JewelCSV();

    private final String auditPath = "./csv/audit.csv";

    private JewelCSV(){}

    @Override
    public ArrayList<Jewel> load(String fileName) throws FileNotFoundException {
        BufferedReader csvReader = new BufferedReader(new FileReader(fileName));
        ArrayList<Jewel> jewel = new ArrayList<Jewel>();
        try {
            String line = csvReader.readLine();
            while (line != null)
            {
                String[] data = line.split(",");
                String[] ingr = line.split(";");
                List<String> l = new ArrayList<>();
                Collections.addAll(l, ingr);
                Jewel jwl = new Jewel(data[0],Integer.parseInt(data[1]), new Shop(data[2], data[3]));
                jewel.add(jwl);
                line = csvReader.readLine();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        audit(auditPath, "add jewel");
        return jewel;
    }

    @Override
    public void add(String fileName, Jewel content) {
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
        audit(auditPath, "jewel added");
    }

    public static JewelCSV getInstance() {
        return INSTANCE;
    }
}
