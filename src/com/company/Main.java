package com.company;


import com.company.Classes.Employee;
import com.company.Classes.Jewel;
import com.company.Classes.Shop;
import com.company.Service.ClientService;
import com.company.Service.ShopService;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private Scanner s = new Scanner(System.in);
    private ShopService shopServices = new ShopService();
    private ClientService clientServices = new ClientService();
    private List<Employee> employees;
    public Main() throws FileNotFoundException {
    }


    public static void main(String args[]) throws FileNotFoundException {
        Main menu = new Main();
        System.out.println("Shop menu");
        while (true)
        {
            System.out.println("""
            0.Exit
            1.Add client
            2.Display clients
            3.Add shop
            4.Display shops
            5.Check if a shop is available
            6.
            7.Add ring
            8.Add necklace
            9.Display all the products from the shops
            10.Display all the products from a given shop
            """);

            System.out.println("Optiune: ");
            int option = menu.Optiune();
            menu.meniu(option);
        }
    }

    private int Optiune()
    {
        try
        {
            int optiune = Integer.parseInt(s.nextLine());
            if (optiune >= 0 && optiune < 12)
            {
                return optiune;
            }
        }
        catch (Exception invalid)
        {

        }
        System.out.println("Invalid option. Please, try again.");
        return Optiune();
    }

    private void meniu(int optiune)
    {
        if(optiune == 1) //adaugare client
        {
            System.out.println("Please enter: ");
            System.out.println("Name:");
            String name = s.nextLine();
            System.out.println("Username:");
            String username = s.nextLine();
            System.out.println("Password:");
            String password = s.nextLine();

            clientServices.addClient(name, username, password);
        }


        else if(optiune == 2) //afisare username clienti
        {
            System.out.println("Our clients are: ");
            for(String e : ClientService.getClients().keySet())
            {
                System.out.println(e);

            }
        }


        //afisare shops

        else if(optiune == 4)
        {

            System.out.println("The shops available are: ");
            for(String sh : ShopService.getShops().keySet())
            {
                System.out.println(sh);


            }

        }

        else if(optiune == 3)
        {

            System.out.println("Please complete the following fields: ");
            System.out.println("Shop name:");
            String name = s.nextLine();
            System.out.println("Shop address:");
            String address = s.nextLine();
            shopServices.addShop(name,address);


        }


        else if(optiune == 5)
        {

            System.out.println("Insert the name of the shop");
            String shopname = s.nextLine();
             shopServices.findShop(shopname);


            if (shopname != null) {
                System.out.println("The shop is available");
            } else if (shopname == null){
                System.out.println("The shop doesn't exist");
            }

        }

        //add ring
        else if(optiune == 7)
        {

            System.out.println("To add a ring, let us know: ");
            System.out.println("Shop name:");
            String name = s.nextLine();
            System.out.println("Ring name:");
            String ringname = s.nextLine();

            System.out.println("Ring price:");
            int price = Integer.parseInt(s.nextLine());
            System.out.println("Ring's weigth:");
            int weigth = Integer.parseInt(s.nextLine());
            System.out.println("Number of elements :");
            int nrelem = Integer.parseInt(s.nextLine());
            System.out.println("Elements:");
            ArrayList <String> Elem = new ArrayList<>();
            for ( int i = 1 ; i <= nrelem ; i++)
            {
                String ing = s.nextLine();
                Elem.add(ing);
            }
            shopServices.addRing(name,ringname,price,weigth,Elem);

        }


        //add necklace
        else if(optiune == 8)
        {

            System.out.println("To add a necklace, let us know: ");
            System.out.println("Shop name:");
            String name = s.nextLine();
            System.out.println("Necklace name:");
            String neckName = s.nextLine();

            System.out.println("Price:");
            int price = Integer.parseInt(s.nextLine());
            System.out.println("Chain length:");
            int leng = Integer.parseInt(s.nextLine());
            shopServices.addNecklace(name,neckName,price,leng);


        }

        //afiseaza toate produsele din magazine
        else if(optiune == 9)
        {

            System.out.println("The products from our shops are: ");
            shopServices.Jewels();


        }
        //afiseaza toate produsele dintr-un magazin dat prin nume
        else if(optiune == 10)
        {

            System.out.println("Please enter the shop name: ");

            String name = s.nextLine();
            System.out.println("The following products are available: ");
            shopServices.JewelsShop(name);


        }

        else if(optiune == 0)
        {
            System.exit(0);
        }
        else
        {
            System.out.println("Invalid option");
        }

    }

}
