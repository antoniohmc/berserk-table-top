package com.rpg.berserk_table_top.controller.diary;

import com.rpg.berserk_table_top.model.Note.Note;

public class NoteMapper {

    static Note mapToEntity(NoteRequest note) {
        return Note.builder()
                .text(note.getText())
                .build();
    }
}
