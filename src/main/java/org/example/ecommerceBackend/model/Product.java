package org.example.ecommerceBackend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String category;
    private BigDecimal price;   // Why use BigDecimal over Double for money?
    private Integer stockQuantity;

    /**
     * This actually solves the biggest issue when it comes to two customers trying to buy
     * the same item at the same time. (Very cool!)
     */
    @Version
    private Long version;
}
