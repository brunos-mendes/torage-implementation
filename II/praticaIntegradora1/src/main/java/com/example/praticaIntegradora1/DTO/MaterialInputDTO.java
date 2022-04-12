package com.example.praticaIntegradora1.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MaterialInputDTO {

    private String name;
    private Double carats;
    private String observations;
    private Double BuyAvgPricePerKg;
    private Double SellPricePerKg;
}
