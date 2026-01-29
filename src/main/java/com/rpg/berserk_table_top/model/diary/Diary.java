package com.rpg.berserk_table_top.model.diary;

import com.rpg.berserk_table_top.model.Note.Note;
import com.rpg.berserk_table_top.model.creature.CreatureNote;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Diary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private List<Note> note;
    private List<CreatureNote> creatureNotes;
}
