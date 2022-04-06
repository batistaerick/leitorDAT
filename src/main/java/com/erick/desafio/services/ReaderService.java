package com.erick.desafio.services;

import com.erick.desafio.entities.*;
import com.erick.desafio.exceptions.ReaderException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReaderService {

    private ReaderService() {
        throw new IllegalStateException("Utility class");
    }

    public static DAT readFiles(File file) {
        try (BufferedReader br = new BufferedReader(
                new FileReader(System.getProperty("user.home") + "\\data\\in\\" + file.getName()))) {

            List<Customer> clients = new ArrayList<>();
            List<Sale> sales = new ArrayList<>();
            List<Salesman> salesmans = new ArrayList<>();

            for (String i = br.readLine(); i != null; i = br.readLine()) {

                String[] j = i.split("ç");

                switch (j[0]) {
                    case "001" -> salesmans.add(new Salesman(Integer.parseInt(j[0]), j[1], j[2], Double.parseDouble(j[3])));
                    case "002" -> clients.add(new Customer(Integer.parseInt(j[0]), j[1], j[2], j[3]));
                    case "003" -> {
                        j[2] = j[2].replace("[", "");
                        j[2] = j[2].replace("]", "");

                        String[] items = j[2].split(",");

                        List<Item> listItems = Arrays.stream(items).toList().stream().map(s -> {
                            String[] item = s.split("-");
                            return (new Item(Integer.parseInt(item[0]), Integer.parseInt(item[1]),
                                    Double.parseDouble(item[2])));
                        }).toList();

                        sales.add(new Sale(Integer.parseInt(j[0]), Integer.parseInt(j[1]), listItems, j[3]));

                        salesmans.forEach(x -> sales.stream().filter(y -> x.getName().equals(y.getSalesManName())).forEach(y -> x.getSales().add(y)));
                    }
                    default -> throw new IllegalStateException("Unexpected value: " + j[0]);
                }
            }
            return new DAT(clients, sales, salesmans);
        } catch (Exception e) {
            throw new ReaderException(e.getMessage());
        }
    }
}