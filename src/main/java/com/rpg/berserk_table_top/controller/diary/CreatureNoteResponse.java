package com.rpg.berserk_table_top.controller.diary;

import com.rpg.berserk_table_top.model.creature.CreatureLanguage;
import com.rpg.berserk_table_top.model.creature.CreatureRarity;
import com.rpg.berserk_table_top.model.creature.CreatureRisk;
import com.rpg.berserk_table_top.model.creature.CreatureType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class CreatureNoteResponse {

    private String id;

    private String name;
    private String senses;
    private String behavior;
    private List<String> observation;

    private CreatureType type;
    private CreatureLanguage language;
    private CreatureRarity rarity;
    private CreatureRisk risk;
}
