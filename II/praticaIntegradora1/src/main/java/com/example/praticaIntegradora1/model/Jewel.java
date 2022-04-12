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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String model;

    @ManyToOne
    @JoinColumn(name="category_id", nullable=false)
    private Category category;

    private String description;

    @ManyToOne
    @JoinColumn(name="material_id", nullable=false)
    private Material material;

    private Double weight;
    private Double price;
    private Double profitMargin;
}
