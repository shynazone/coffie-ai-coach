package com.coffie.coffie_ai_coach.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AiInsightResponse {
    private String summary;
    private String mood;
    private String suggestion;
}
