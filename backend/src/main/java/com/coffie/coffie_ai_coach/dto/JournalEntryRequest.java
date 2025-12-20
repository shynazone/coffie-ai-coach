package com.coffie.coffie_ai_coach.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class JournalEntryRequest {
    private String title;
    private String reflection;
}
