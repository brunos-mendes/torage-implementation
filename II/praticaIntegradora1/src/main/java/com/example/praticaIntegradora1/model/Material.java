package com.example.praticaIntegradora1.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "material")
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private Double carats;
    private String observations;
    private Double BuyAvgPricePerKg;
    private Double SellPricePerKg;

    @OneToMany(mappedBy = "material", cascade = CascadeType.ALL)
    private List<Jewel> jewels = new ArrayList<Jewel>();
}
