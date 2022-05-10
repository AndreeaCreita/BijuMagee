package com.company.Service.csv;

import com.company.Classes.Necklace;
import com.company.Classes.Shop;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class NecklaceCSV implements SingletonCSV<Necklace>{

    private static final NecklaceCSV INSTANCE = new NecklaceCSV();

    private final String auditPath = "./csv/audit.csv";

    private NecklaceCSV(){}

    @Override
    public ArrayList<Necklace> load(String fileName) throws FileNotFoundException {
        BufferedReader csvReader = new BufferedReader(new FileReader(fileName));
        ArrayList<Necklace> necklace = new ArrayList<Necklace>();
        try {
            String line = csvReader.readLine();
            while (line != null)
            {
                String[] data = line.split(",");
                Necklace neck = new Necklace(data[0], Integer.parseInt(data[2]), new Shop(data[3], data[4]),Integer.parseInt(data[4]));
                necklace.add(neck);
                line = csvReader.readLine();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        audit(auditPath, "add necklace");
        return necklace;
    }


    @Override
    public void add(String fileName, Necklace content) {
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
        audit(auditPath, "necklace added");
    }

    public static NecklaceCSV getInstance() {
        return INSTANCE;
    }
}
