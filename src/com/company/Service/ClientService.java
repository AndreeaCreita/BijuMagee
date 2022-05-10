package com.company.Service;

import com.company.Classes.Client;
import com.company.Service.csv.ClientCSV;

import java.io.FileNotFoundException;
import java.util.HashMap;

public class ClientService {

        private static HashMap<String, Client> clients;

    public ClientService() throws FileNotFoundException {
        clients = new HashMap<>();
        for(Client u : ClientCSV.getInstance().load("./csv/clients.csv"))
        {
            clients.put(u.getUsername() ,u);
        }
    }

    public void addClient(String name, String username, String password){
        Client client = new Client(name, username, password);
        clients.put(username, client);
        ClientCSV.getInstance().add("./csv/clients.csv", client);
    }

    public static HashMap<String, Client> getClients(){
        return clients;
    }
}
