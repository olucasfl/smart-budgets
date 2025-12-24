package com.smart_buckets.api.service;

import com.smart_buckets.api.dtos.request.HubRequestDto;
import com.smart_buckets.api.dtos.response.HubDetailResponseDto;
import com.smart_buckets.api.dtos.response.HubSummaryResponseDto;
import com.smart_buckets.api.entity.Hub;
import com.smart_buckets.api.exceptions.NotFoundException;
import com.smart_buckets.api.repository.HubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HubService {

    private final HubRepository hubRepository;

    //Rota para criar um Hub
    public HubSummaryResponseDto createHub (HubRequestDto dto) {

        Hub hub = new Hub();

        hub.setName(dto.getName());
        hub.setBudgetLimit(dto.getBudgetLimit());
        hub.setDescription(dto.getDescription());

        Hub saved = hubRepository.save(hub);

        return new HubSummaryResponseDto(saved);
    }

    //Rota para listar todos os Hubs minimizados
    public List<HubSummaryResponseDto> findAllSummaryHub() {

        List<Hub> hubs = hubRepository.findAll();

        return hubs.stream()
                .map(HubSummaryResponseDto::new)
                .toList();
    }

    //Rota para listar o Hub específico detalhado
    public HubDetailResponseDto findHubById(Long id) {

        Hub hub = hubRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Hub não encontrado"));

        return new HubDetailResponseDto(hub);
    }

    public void deleteHub(Long id) {

        Hub hub = hubRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Hub não encontrado"));

        hubRepository.delete(hub);
    }

    public HubSummaryResponseDto updateHubSummary(Long id, HubRequestDto dto) {

        Hub hub = hubRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Hub não encontrado"));

        hub.setName(dto.getName());
        hub.setDescription(dto.getDescription());
        hub.setBudgetLimit(dto.getBudgetLimit());

        hubRepository.save(hub);

        return new HubSummaryResponseDto(hub);
    }
}
