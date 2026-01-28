package com.rpg.berserk_table_top.controller.creature;

import com.rpg.berserk_table_top.model.creature.CreatureNote;

public class CreatureNoteMapper {

    static CreatureNoteResponse mapToResponse(CreatureNote creatureNote) {
        return CreatureNoteResponse.builder()
                .id(creatureNote.getId())
                .name(creatureNote.getName())
                .senses(creatureNote.getSenses())
                .behavior(creatureNote.getBehavior())
                .observation(creatureNote.getObservation())
                .type(creatureNote.getType())
                .language(creatureNote.getLanguage())
                .rarity(creatureNote.getRarity())
                .risk(creatureNote.getRisk())
                .build();
    }

    static CreatureNote mapToRequest(CreatureNoteRequest creatureNote) {
        return CreatureNote.builder()
                .name(creatureNote.getName())
                .senses(creatureNote.getSenses())
                .behavior(creatureNote.getBehavior())
                .observation(creatureNote.getObservation())
                .type(creatureNote.getType())
                .language(creatureNote.getLanguage())
                .rarity(creatureNote.getRarity())
                .risk(creatureNote.getRisk())
                .build();
    }
}
