package com.coffie.coffie_ai_coach.repository;

import com.coffie.coffie_ai_coach.entity.JournalEntryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalRepository extends JpaRepository<JournalEntryEntity, Long> {
}
