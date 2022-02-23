package com.ilegra.desafio.services;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

import com.ilegra.desafio.entities.DAT;
import com.ilegra.desafio.entities.Item;
import com.ilegra.desafio.entities.Sale;
import com.ilegra.desafio.entities.Salesman;

public class WriterService {

    private WriterService() {
        throw new IllegalStateException("Utility class");
    }

    private static String worst;
    private static Integer idExpensive;
    private static Double priceExpensive;
    private static Double totalSales;

    public static void writeFile(File file, DAT dat) {
        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter(System.getProperty("user.home") + "\\data\\out\\" + file.getName().replace(".dat", "")
                        + ".done.dat"))) {

            bw.write("Amount of clients: " + dat.getClients().size() + "\n");
            bw.write("Amount of salesman: " + dat.getSalesmans().size() + "\n");
            bw.write("ID of the most expensive sale: " + mostExpensiveSale(dat.getSales()) + "\n");
            bw.write("Worst salesman ever: " + worstSalesman(dat.getSalesmans()) + "\n");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Integer mostExpensiveSale(List<Sale> sales) {
        List<List<Item>> listItems = sales.stream().map(Sale::getItems).toList();

        listItems.forEach(x -> {
            idExpensive = 0;
            priceExpensive = 0d;

            x.stream().filter(y -> y.getPrice() * y.getQuantity() > priceExpensive).forEach(y -> {
                priceExpensive = y.getPrice() * y.getQuantity();
                idExpensive = y.getId();
            });
        });
        return idExpensive;
    }

    private static String worstSalesman(List<Salesman> salesmans) {
        salesmans.forEach(x -> x.getSales().forEach(y -> {
            x.setTotalSales(0D);
            y.getItems().forEach(z -> x.setTotalSales(z.getPrice() * z.getQuantity() + x.getTotalSales()));
        }));

        totalSales = salesmans.stream().mapToDouble(Salesman::getTotalSales).sum();

        salesmans.stream().filter(x -> x.getTotalSales() < totalSales).forEach(x -> {
            totalSales = x.getTotalSales();
            worst = x.getName();
        });
        return worst;
    }
}