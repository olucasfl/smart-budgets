package com.smart_buckets.api.entity;

import com.smart_buckets.api.enums.ExpenseType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "tb_expense")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Expense {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "expense_type")
    private ExpenseType type;

    @Column(name = "amount")
    private BigDecimal amount;

    @CreationTimestamp
    @Column(name = "createAt", updatable = false)
    private LocalDateTime createAt;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "hub_id")
    private Hub hub;
}