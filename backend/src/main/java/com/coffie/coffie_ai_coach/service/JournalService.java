package com.coffie.coffie_ai_coach.service;

import com.coffie.coffie_ai_coach.entity.JournalEntryEntity;
import com.coffie.coffie_ai_coach.exception.JournalNotFoundException;
import com.coffie.coffie_ai_coach.model.dto.JournalEntryRequest;
import com.coffie.coffie_ai_coach.repository.JournalRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JournalService {
//    //Using In memory
//
//    private final List<JournalEntryRequest> entries = new ArrayList<JournalEntryRequest>();
//
//    public JournalEntryRequest addEntry(JournalEntryRequest entry){
//        entries.add(entry);
//        return entry;
//    }
//
//    public List<JournalEntryRequest> getEntries(){
//        System.out.println(entries);
//        return entries;
//    }
//
//    public JournalEntryRequest getEntryByIndex(int index){
//        System.out.println(entries);
//        if(index<0 || index> entries.size()){
//            throw new JournalNotFoundException("Journal Not found");
//        }
//        return entries.get(index);
//    }

    private final JournalRepository repository;

    public JournalService(JournalRepository repository){
        this.repository = repository;
    }

    public JournalEntryRequest addEntry(JournalEntryRequest entry){
        JournalEntryEntity entity = new JournalEntryEntity();
        entity.setTitle(entry.getTitle());
        entity.setReflection(entry.getReflection());
        entity.setCreatedAt(System.currentTimeMillis());
        repository.save(entity);
        return entry;
    }

    public List<JournalEntryRequest> getEntries(){
        return repository.findAll().stream()
                .map(e->
                        new JournalEntryRequest(e.getTitle(), e.getReflection())).toList();
    }

}
