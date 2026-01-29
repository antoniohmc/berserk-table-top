package com.rpg.berserk_table_top.controller.diary;

import com.rpg.berserk_table_top.model.diary.Diary;

public class DiaryMapper {

    static Diary mapToEntity(DiaryRequest diary) {
        return Diary.builder()
                .name(diary.getName())
                .accountPlayerId(diary.getAccountPlayerId())
                .creatureNotesId(diary.getCreatureNotesId())
                .notesId(diary.getNotesId())
                .build();

    }
}
