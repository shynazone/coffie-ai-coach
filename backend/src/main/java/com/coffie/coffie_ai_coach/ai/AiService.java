package com.coffie.coffie_ai_coach.ai;

import com.coffie.coffie_ai_coach.model.dto.AiInsightResponse;
import com.coffie.coffie_ai_coach.model.dto.JournalEntryRequest;
import com.coffie.coffie_ai_coach.service.JournalService;
import org.springframework.stereotype.Service;


@Service
public class AiService {
    private final JournalService journalService;
    private final HuggingFaceAiClient aiClient;

    public AiService(JournalService journalService, HuggingFaceAiClient aiClient){
        this.journalService = journalService;
        this.aiClient = aiClient;
    }

    public AiInsightResponse getInsights() {

        String combinedJournalText = journalService.getEntries().stream().
                map(JournalEntryRequest::getReflection).reduce("", (a, b)->a+". "+b);

        return aiClient.getInsight(combinedJournalText);
    }
}
