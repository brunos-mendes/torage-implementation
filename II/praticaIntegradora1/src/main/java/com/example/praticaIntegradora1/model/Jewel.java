package com.example.praticaIntegradora1.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "jewel")
public class Jewel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String model;

    @ManyToOne
    private Category category;

    private String description;

    @ManyToOne
    private Material material;

    private Double weight;
    private Double price;
    private Double profitMargin;
}
