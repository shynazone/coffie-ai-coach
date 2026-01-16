package com.coffie.coffie_ai_coach.ai;

import com.coffie.coffie_ai_coach.model.dto.AiInsightResponse;
import com.coffie.coffie_ai_coach.model.dto.JournalEntryRequest;
import com.coffie.coffie_ai_coach.service.JournalService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AiService {
    private final JournalService journalService;
    private final AiClient aiClient;

    public AiService(JournalService journalService, AiClient aiClient){
        this.journalService = journalService;
        this.aiClient = aiClient;
    }

    public AiInsightResponse getInsights() {

        List<String> reflections = journalService.getEntries().stream().
                map(JournalEntryRequest::getReflection).toList();

        String insight = aiClient.generateInsight(reflections);

        return new AiInsightResponse(insight, "reflective", "tip #1 from ai");

    }
}
