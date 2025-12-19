package com.smart_buckets.api.dtos.response;

import com.smart_buckets.api.enums.ExpenseType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseResponseDto {

    private Long id;
    private String name;
    private BigDecimal amount;
    private String description;
    private ExpenseType type;
}
