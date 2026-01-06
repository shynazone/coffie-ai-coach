package com.coffie.coffie_ai_coach.service;

import com.coffie.coffie_ai_coach.exception.JournalNotFoundException;
import com.coffie.coffie_ai_coach.model.dto.JournalEntryRequest;
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

    public JournalEntryRequest getEntryByIndex(int index){
        System.out.println(entries);
        if(index<0 || index> entries.size()){
            throw new JournalNotFoundException("Journal Not found");
        }
        return entries.get(index);
    }

}
