package com.smart_buckets.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Table(name = "tb_hub")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hub {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "budget_limit")
    private BigDecimal budgetLimit;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "hub", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Expense> expenses;
}