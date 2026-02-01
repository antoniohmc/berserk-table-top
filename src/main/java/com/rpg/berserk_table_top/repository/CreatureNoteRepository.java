package com.rpg.berserk_table_top.repository;

import com.rpg.berserk_table_top.model.creature.CreatureNote;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CreatureNoteRepository extends MongoRepository<CreatureNote, String> {

    Optional<CreatureNote> findById(String id);
}
