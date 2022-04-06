package com.erick.desafio.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Salesman implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String cpf;
    private String name;
    private Double salary;
    private List<Sale> sales;
    private Double totalSales;

    public Salesman(Integer id, String cpf, String name, Double salary) {
        this.id = id;
        this.cpf = cpf;
        this.name = name;
        this.salary = salary;
    }
}