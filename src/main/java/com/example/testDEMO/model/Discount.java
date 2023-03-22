package com.example.testDEMO.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "discounts")
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double amount;
    private LocalDateTime start;
    private LocalDateTime end;

    @ManyToMany
    @JoinTable(name="discount_product",joinColumns = @JoinColumn(name = "discount_id"),inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;
}
