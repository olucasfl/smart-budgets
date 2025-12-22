package com.smart_buckets.api.controller;

import com.smart_buckets.api.dtos.request.ExpenseRequestDto;
import com.smart_buckets.api.dtos.response.ExpenseResponseDto;
import com.smart_buckets.api.service.ExpenseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hub/{hubId}/expense")
public class ExpenseController {

    private final ExpenseService expenseService;

    @PostMapping("/create")
    public ResponseEntity<ExpenseResponseDto> createExpense(@PathVariable Long hubId,
                                                            @Valid @RequestBody ExpenseRequestDto dto) {

        return ResponseEntity.ok(expenseService.createExpense(hubId, dto));
    }
}
