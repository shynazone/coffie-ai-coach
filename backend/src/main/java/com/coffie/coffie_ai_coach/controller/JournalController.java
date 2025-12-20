package com.coffie.coffie_ai_coach.controller;

import com.coffie.coffie_ai_coach.dto.JournalEntryRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/journal")
public class JournalController {

    @PostMapping
    public JournalEntryRequest createJournalEntry(@RequestBody JournalEntryRequest entryRequest){
        System.out.println("Received the entry: "+ entryRequest);
        return entryRequest;
    }
}