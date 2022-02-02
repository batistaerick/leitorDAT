package com.ilegra.desafio.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.ilegra.desafio.entities.Customer;
import com.ilegra.desafio.entities.DAT;
import com.ilegra.desafio.entities.Item;
import com.ilegra.desafio.entities.Sale;
import com.ilegra.desafio.entities.Salesman;

public class Reader {

    private Reader() {
        throw new IllegalStateException("Utility class");
    }

    public static DAT readFiles(File file) {

        List<Customer> clients = new ArrayList<>();
        List<Sale> sales = new ArrayList<>();
        List<Salesman> salesmans = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(
                new FileReader(System.getProperty("user.home") + "\\data\\in\\" + file.getName()))) {

            for (String i = br.readLine(); i != null; i = br.readLine()) {

                String id = i.substring(0, 3);
                String[] j = i.split("ç");

                if (id.equals("001")) {
                    salesmans.add(new Salesman(Integer.parseInt(j[0]), j[1], j[2], Double.parseDouble(j[3])));

                } else if (id.equals("002")) {
                    clients.add(new Customer(Integer.parseInt(j[0]), j[1], j[2], j[3]));

                } else if (id.equals("003")) {

                    j[2] = j[2].replace("[", "");
                    j[2] = j[2].replace("]", "");

                    String[] items = j[2].split(",");

                    List<Item> listItems = new ArrayList<>();

                    for (int k = 0; k < items.length; k++) {
                        String[] item = items[k].split("-");

                        listItems.add(new Item(Integer.parseInt(item[0]), Integer.parseInt(item[1]),
                                Double.parseDouble(item[2])));
                    }

                    sales.add(new Sale(Integer.parseInt(j[0]), Integer.parseInt(j[1]), listItems, j[3]));

                    salesmans.forEach(x -> sales.stream().forEach(y -> {
                        if (x.getName().equals(y.getSalesManName())) {
                            x.getSales().add(y);
                        }
                    }));
                }
            }
            return new DAT(clients, sales, salesmans);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}