package com.rpg.berserk_table_top.controller.diary;

import com.rpg.berserk_table_top.model.creature.CreatureNote;
import com.rpg.berserk_table_top.service.diary.CreatureNotesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/creaturenote")
@RequiredArgsConstructor
public class CreatureNoteController {

    private final CreatureNotesService creatureNotesService;

    @PostMapping("/adicionar/{diaryId}")
    public ResponseEntity<CreatureNoteResponse> registerCreatureNote(@PathVariable String diaryId, @RequestBody CreatureNoteRequest request) {
        CreatureNote creature = CreatureNoteMapper.mapToEntity(request);
        CreatureNote saved = creatureNotesService.registerCreatureNote(diaryId, creature);

        return ResponseEntity.ok(
                CreatureNoteMapper.mapToResponse(saved)
        );
    }
}
