package com.smart_buckets.api.controller;

import com.smart_buckets.api.dtos.response.HubSummaryResponseDto;
import com.smart_buckets.api.service.HubService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hub")
public class HubController {

    HubService hubService;

    @GetMapping("/list-summary")
    public ResponseEntity<List<HubSummaryResponseDto>> listAllSummary() {

        return ResponseEntity.ok(hubService.findAllSummaryHub());
    }
}
