package com.smart_buckets.api.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HubRequestDto {

    @NotBlank(message = "O nome é obrigatório")
    private String name;

    @NotNull(message = "O limite é obrigatório")
    private BigDecimal budgetLimit;

    private String description;
}