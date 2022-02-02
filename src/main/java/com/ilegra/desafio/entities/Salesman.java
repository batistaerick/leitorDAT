package com.ilegra.desafio.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Salesman implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String cpf;
    private String name;
    private Double salary;
    private List<Sale> sales = new ArrayList<>();
    private Double totalSales;

    public Salesman(Integer id, String cpf, String name, Double salary) {
        this.id = id;
        this.cpf = cpf;
        this.name = name;
        this.salary = salary;
    }
}