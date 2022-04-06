package com.erick.desafio.entities;

import java.io.Serial;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String cnpj;
    private String name;
    private String businessArea;
}