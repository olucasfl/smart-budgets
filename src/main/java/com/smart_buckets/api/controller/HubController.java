package com.smart_buckets.api.controller;

import com.smart_buckets.api.dtos.request.HubRequestDto;
import com.smart_buckets.api.dtos.response.HubDetailResponseDto;
import com.smart_buckets.api.dtos.response.HubSummaryResponseDto;
import com.smart_buckets.api.service.HubService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hub")
public class HubController {

    private final HubService hubService;

    @PostMapping("/create")
    public ResponseEntity<HubSummaryResponseDto> createHub(
            @Valid @RequestBody HubRequestDto dto
            ) {

        return ResponseEntity.ok(hubService.createHub(dto));
    }

    @GetMapping("/list-summary")
    public ResponseEntity<List<HubSummaryResponseDto>> listAllSummary() {

        return ResponseEntity.ok(hubService.findAllSummaryHub());
    }

    @GetMapping("/list-detail/{id}")
    public ResponseEntity<HubDetailResponseDto> listAllDetail(
            @PathVariable Long id
    ) {

        return ResponseEntity.ok(hubService.findHubById(id));
    }
}
