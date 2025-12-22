package com.coffie.coffie_ai_coach.service;

import com.coffie.coffie_ai_coach.dto.JournalEntryRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JournalService {
    private final List<JournalEntryRequest> entries = new ArrayList<JournalEntryRequest>();

    public JournalEntryRequest addEntry(JournalEntryRequest entry){
        entries.add(entry);
        return entry;
    }

    public List<JournalEntryRequest> getEntries(){
        System.out.println(entries);
        return entries;
    }

}
