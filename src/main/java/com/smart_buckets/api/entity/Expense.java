package com.smart_buckets.api.entity;

import com.smart_buckets.api.enums.ExpenseType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Table(name = "tb_expense", schema = "bd_smart-budgets")
@Entity
@Data
@AllArgsConstructor
public class Expense {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long Id;

    @Column(name = "name")
    private String name;

    @Column(name = "expense-type")
    private ExpenseType type;

    @Column(name = "description")
    private String description;
}