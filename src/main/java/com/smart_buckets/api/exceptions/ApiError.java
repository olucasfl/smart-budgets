package com.smart_buckets.api.exceptions;

import java.time.Instant;

public record ApiError(Instant timestamp, Integer status, String error) {
}