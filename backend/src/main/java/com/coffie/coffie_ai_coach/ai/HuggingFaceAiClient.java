package com.coffie.coffie_ai_coach.ai;

import com.coffie.coffie_ai_coach.model.dto.AiInsightResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
@Component
public class HuggingFaceAiClient {

    @Value("${huggingface.api.key}")
    private String apiKey;

    @Value("${huggingface.api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate;

    public HuggingFaceAiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public AiInsightResponse getInsight(String journalText) {

        try {
            // HF request
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setBearerAuth(apiKey);
            headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
            headers.add(HttpHeaders.ACCEPT_CHARSET, StandardCharsets.UTF_8.name());

            Map<String, Object> requestBody = Map.of(
                    "inputs", journalText,
                    "parameters", Map.of(
                            "max_length", 120
                    )
            );

            HttpEntity<Map<String, Object>> request =
                    new HttpEntity<>(requestBody, headers);

            ResponseEntity<List> response =
                    restTemplate.postForEntity(apiUrl, request, List.class);

            if (response.getBody() == null || response.getBody().isEmpty()) {
                throw new RuntimeException("Empty AI response");
            }

            Map<?, ?> firstResult = (Map<?, ?>) response.getBody().get(0);
            String summary = (String) firstResult.get("summary_text");

            return new AiInsightResponse(
                    summary,
                    "Reflective",
                    "Write one small positive moment today"
            );
        } catch (ResourceAccessException e) {
          //  return mockAiClient.generateInsight(journalText);
            throw new RuntimeException("AI service timeout. Please try again later.");
        }

    }
}
