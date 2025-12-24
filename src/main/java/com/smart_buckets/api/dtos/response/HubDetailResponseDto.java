package com.smart_buckets.api.dtos.response;

import com.smart_buckets.api.entity.Hub;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HubDetailResponseDto {

    private Long id;
    private String name;
    private BigDecimal budgetLimit;
    private String description;
    private List<ExpenseResponseDto> expenses;

    public HubDetailResponseDto(Hub hub) {
        this.id = hub.getId();
        this.name = hub.getName();
        this.budgetLimit = hub.getBudgetLimit();
        this.description = hub.getDescription();

        this.expenses = hub.getExpenses()
                .stream()
                .map(ExpenseResponseDto::new)
                .toList();
    }
}
