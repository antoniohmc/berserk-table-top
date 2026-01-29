package com.rpg.berserk_table_top.repository;

import com.rpg.berserk_table_top.model.creature.CreatureNote;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CreatureNoteRepository extends MongoRepository <CreatureNote, String> {

}
