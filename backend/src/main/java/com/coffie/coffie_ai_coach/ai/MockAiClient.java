package com.coffie.coffie_ai_coach.ai;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MockAiClient implements AiClient {
    @Override
   public String generateInsight(List<String> reflections){
        if(reflections.isEmpty()){
            return "No journals recorded";
        }
        else
            return "You are a thoughtful person, i am ai telling you some suggestions blah blah";
    }

}
