package com.coffie.coffie_ai_coach.controller;

import com.coffie.coffie_ai_coach.dto.JournalEntryRequest;
import com.coffie.coffie_ai_coach.service.JournalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/journal")
public class JournalController {

    JournalService journalService = new JournalService();

    @PostMapping
    public JournalEntryRequest createJournalEntry(@RequestBody JournalEntryRequest entryRequest){
        return journalService.addEntry(entryRequest);
    }

    @GetMapping
    public List<JournalEntryRequest> getAllEntries(){
        return journalService.getEntries();
    }
}