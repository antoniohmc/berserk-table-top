package com.rpg.berserk_table_top.service.diary;

import com.rpg.berserk_table_top.exeptions.diary.NotFoundDiary;
import com.rpg.berserk_table_top.model.creature.CreatureNote;
import com.rpg.berserk_table_top.model.diary.Diary;
import com.rpg.berserk_table_top.repository.CreatureNoteRepository;
import com.rpg.berserk_table_top.repository.DiaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreatureNotesService {

    private final CreatureNoteRepository creatureNoteRepository;
    private final DiaryRepository diaryRepository;

    public CreatureNote registerCreatureNote (String diaryId, CreatureNote creatureNote) {
        Diary diary = diaryRepository.findById(diaryId)
                .orElseThrow(() -> new NotFoundDiary("Nenhum Diario registrado para adicionar notas!"));

        CreatureNote creature = CreatureNote.builder()
                .diaryId(creatureNote.getDiaryId())
                .name(creatureNote.getName())
                .senses(creatureNote.getSenses())
                .behavior(creatureNote.getBehavior())
                .observation(creatureNote.getObservation())
                .type(creatureNote.getType())
                .language(creatureNote.getLanguage())
                .rarity(creatureNote.getRarity())
                .risk(creatureNote.getRisk())
                .build();

        CreatureNote saved = creatureNoteRepository.save(creature);

        diary.getCreatureNotesId().add(saved.getId());
        diaryRepository.save(diary);

        return creatureNote;
    }
}
