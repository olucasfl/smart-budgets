package com.smart_buckets.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Table(name = "tb_hub", schema = "bd_smart-buckets")
@Entity
@Data
@AllArgsConstructor
public class Hub {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long Id;

    @Column(name = "name")
    private String name;

    @Column(name = "budget-limit")
    private Long budgetLimit;

    @Column(name = "descirption")
    private String description;
}