package com.rpg.berserk_table_top.repository;

import com.rpg.berserk_table_top.model.diary.Diary;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DiaryRepository extends MongoRepository<Diary, String> {

    void deleteByAccountPlayerId(String accountPlayerId);
}
