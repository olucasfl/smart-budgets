package com.smart_buckets.api.service;

import com.smart_buckets.api.dtos.request.ExpenseRequestDto;
import com.smart_buckets.api.dtos.response.ExpenseResponseDto;
import com.smart_buckets.api.entity.Expense;
import com.smart_buckets.api.entity.Hub;
import com.smart_buckets.api.exceptions.NotFoundException;
import com.smart_buckets.api.repository.ExpenseRepository;
import com.smart_buckets.api.repository.HubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final HubRepository hubRepository;

    public ExpenseResponseDto createExpense(Long hubId ,ExpenseRequestDto dto) {

        Hub hub = hubRepository.findById(hubId)
                .orElseThrow(() -> new NotFoundException("Hub não encontrado"));

        Expense expense = new Expense();

        expense.setName(dto.getName());
        expense.setType(dto.getType());
        expense.setAmount(dto.getAmount());
        expense.setDescription(dto.getDescription());
        expense.setHub(hub);

        Expense saved = expenseRepository.save(expense);

        return new ExpenseResponseDto(saved);
    }

    public void deleteExpense(Long hubId, Long id) {

    Expense expense = expenseRepository.findByIdAndHubId(id, hubId)
                    .orElseThrow(() -> new NotFoundException("Gasto não encontrado"));

        expenseRepository.delete(expense);
    }

    public ExpenseResponseDto updateExpense(ExpenseRequestDto dto, Long id, Long hubId) {

        Expense expense = expenseRepository.findByIdAndHubId(id, hubId)
                        .orElseThrow(() -> new NotFoundException("Gasto não encontrado"));

        expense.setName(dto.getName());
        expense.setType(dto.getType());
        expense.setAmount(dto.getAmount());
        expense.setDescription(dto.getDescription());

        expenseRepository.save(expense);

        return new ExpenseResponseDto(expense);
    }
}
