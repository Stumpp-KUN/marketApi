package com.example.testDEMO.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "products") //можно опустить конечно, но для наглядности буду писать, аннотации column я опустил
@Data
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    @ManyToOne
    private Organization organization;
    private Double price;
    private Integer quantity;
    @ManyToMany(mappedBy = "products")
    private List<Discount> discount;
    @OneToMany(mappedBy = "product")
    private List<Review> reviews;
    @ElementCollection
    private List<String> keywords;
    @OneToMany(mappedBy = "name")
    private List<Characteristic> characteristics;
    @OneToMany(mappedBy = "product")
    private List<Rating> ratings;
}
