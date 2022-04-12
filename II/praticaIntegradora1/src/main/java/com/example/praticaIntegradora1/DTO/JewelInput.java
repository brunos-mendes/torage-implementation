package com.example.praticaIntegradora1.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JewelInput {

    private String model;
    private Integer category_id;
    private String description;
    private Integer material_id;
    private Double weight;
    private Double price;
    private Double profitMargin;
}
