package com.smart_buckets.api.dtos.request;

import com.smart_buckets.api.enums.ExpenseType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseRequestDto {

    @NotBlank(message = "O nome é obrigatório")
    private String name;

    @NotNull(message = "O tipo é obrigatório")
    private ExpenseType type;

    @NotNull(message = "A quantia é obrigatória")
    private BigDecimal amount;

    private String description;
}