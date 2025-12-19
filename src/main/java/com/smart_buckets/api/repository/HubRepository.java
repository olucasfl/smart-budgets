package com.smart_buckets.api.repository;

import com.smart_buckets.api.dtos.response.HubSummaryResponseDto;
import com.smart_buckets.api.entity.Hub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HubRepository extends JpaRepository<Hub, Long> {
}
