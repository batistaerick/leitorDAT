package com.ilegra.desafio.entities;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DAT implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Customer> clients;
    private List<Sale> sales;
    private List<Salesman> salesmans;
}