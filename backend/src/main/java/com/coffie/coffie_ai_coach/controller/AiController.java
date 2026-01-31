package com.coffie.coffie_ai_coach.controller;

import com.coffie.coffie_ai_coach.ai.AiService;
import com.coffie.coffie_ai_coach.model.dto.AiInsightResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "https://coffie-ai-coach-frontend.onrender.com/")
@RestController
@RequestMapping("/api/ai")
public class AiController {
    private final AiService aiService;

    public AiController(AiService aiService){
        this.aiService = aiService;
    }

    @GetMapping("/insight")
    public AiInsightResponse getInsight(){
       return aiService.getInsights();
    }

}
