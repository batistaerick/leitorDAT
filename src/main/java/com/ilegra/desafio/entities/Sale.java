package com.ilegra.desafio.entities;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sale implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private Integer salesId;
    private List<Item> items;
    private String salesManName;
}