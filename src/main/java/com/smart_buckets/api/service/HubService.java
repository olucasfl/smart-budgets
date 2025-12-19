package com.smart_buckets.api.service;

import com.smart_buckets.api.dtos.request.HubRequestDto;
import com.smart_buckets.api.dtos.response.HubDetailResponseDto;
import com.smart_buckets.api.dtos.response.HubSummaryResponseDto;
import com.smart_buckets.api.entity.Hub;
import com.smart_buckets.api.repository.HubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HubService {

    private final HubRepository hubRepository;

    //Rota para criar um Hub
    public void createHub (HubRequestDto dto) {

        Hub hub = new Hub();

        hub.setName(dto.getName());
        hub.setBudgetLimit(dto.getBudgetLimit());
        hub.setDescription(dto.getDescription());

        hubRepository.save(hub);
    }

    //Rota para listar todos os Hubs minimizados
    public List<HubSummaryResponseDto> findAllSummaryHub() {

        return hubRepository.findAll()
                .stream()
                .map(hub -> new HubSummaryResponseDto(hub.getId(), hub.getName()))
                .collect(Collectors.toList());
    }

    //Rota para listar o Hub específico detalhado
    public HubDetailResponseDto findHubById() {

        return new HubDetailResponseDto();
    }
}
