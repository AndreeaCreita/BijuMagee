package com.company.Service.csv;

import com.company.Classes.Client;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class ClientCSV implements SingletonCSV<Client> {
    private static final ClientCSV INSTANCE = new ClientCSV();

    private final String auditPath = "./csv/audit.csv";

    private ClientCSV(){}

    @Override
    public ArrayList<Client> load(String fileName) throws FileNotFoundException {
        BufferedReader csvReader = new BufferedReader(new FileReader(fileName));
        ArrayList<Client> clients = new ArrayList<Client>();
        try {
            String line = csvReader.readLine();
            while (line != null)
            {
                String[] data = line.split(",");
                Client client = new Client(data[0], data[1], data[2]);
                clients.add(client);
                line = csvReader.readLine();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        audit(auditPath, "add client");
        return clients;
    }


    @Override
    public void add(String fileName, Client content) {
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
        audit(auditPath, "client added");
    }

    public static ClientCSV getInstance() {
        return INSTANCE;
    }
}