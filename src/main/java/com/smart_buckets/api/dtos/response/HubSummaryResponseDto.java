package com.smart_buckets.api.dtos.response;

import com.smart_buckets.api.entity.Hub;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HubSummaryResponseDto {

    private Long id;

    private String name;

    public HubSummaryResponseDto(Hub hub) {
        this.id = hub.getId();
        this.name = hub.getName();
    }
}
