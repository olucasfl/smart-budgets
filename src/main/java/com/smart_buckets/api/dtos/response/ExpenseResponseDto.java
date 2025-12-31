package com.smart_buckets.api.dtos.response;

import com.smart_buckets.api.entity.Expense;
import com.smart_buckets.api.enums.ExpenseType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseResponseDto {

    private Long id;
    private String name;
    private BigDecimal amount;
    private String description;
    private ExpenseType type;
    private LocalDateTime createAt;

    public ExpenseResponseDto(Expense expense) {
        this.id = expense.getId();
        this.name = expense.getName();
        this.amount = expense.getAmount();
        this. description = expense.getDescription();
        this.type = expense.getType();
        this.createAt = expense.getCreateAt();
    }
}
