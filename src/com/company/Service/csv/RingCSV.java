package com.company.Service.csv;

import com.company.Classes.Ring;
import com.company.Classes.Shop;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RingCSV implements SingletonCSV<Ring>{

    private static final RingCSV INSTANCE = new RingCSV();

    private final String auditPath = "./csv/audit.csv";

    private RingCSV(){}

    @Override
    public ArrayList<Ring> load(String fileName) throws FileNotFoundException {
        BufferedReader csvReader = new BufferedReader(new FileReader(fileName));
        ArrayList<Ring> ring = new ArrayList<Ring>();
        try {
            String line = csvReader.readLine();
            while (line != null)
            {
                String[] data = line.split(",");
                String[] ingr = line.split(";");
                List<String> l = new ArrayList<>();
                Collections.addAll(l, ingr);
                Ring rng = new Ring(data[0], Integer.parseInt(data[1]),new Shop(data[2], data[3]),Integer.parseInt(data[5]),l);
                ring.add(rng);
                line = csvReader.readLine();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        audit(auditPath, "add ring");
        return ring;
    }


    @Override
    public void add(String fileName, Ring content) {
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
        audit(auditPath, "ring added");
    }

    public static RingCSV getInstance() {
        return INSTANCE;
    }
}
