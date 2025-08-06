package com.accenture.challenge.dto;

import java.time.LocalDateTime;

public record ErrorResponseDto(int status, String code, String message, String path, LocalDateTime timestamp) {}
