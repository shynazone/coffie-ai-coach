package com.coffie.coffie_ai_coach.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class JournalEntryRequest {
    @NotBlank(message="Title cannot be empty")
    private String title;
    @NotBlank(message="Reflection cannot be empty")
    private String reflection;
}
