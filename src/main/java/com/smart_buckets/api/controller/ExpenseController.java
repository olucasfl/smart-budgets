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

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteExpense(
            @PathVariable Long hubId,
            @PathVariable Long id
    ) {
        expenseService.deleteExpense(hubId, id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ExpenseResponseDto> updateHub(
            @RequestBody ExpenseRequestDto dto,
            @PathVariable Long hubId,
            @PathVariable Long id) {

        return ResponseEntity.ok(expenseService.updateExpense(dto, id, hubId));
    }
}
