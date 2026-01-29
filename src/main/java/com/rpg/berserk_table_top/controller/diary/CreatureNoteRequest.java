package com.rpg.berserk_table_top.controller.diary;

import com.rpg.berserk_table_top.model.creature.CreatureLanguage;
import com.rpg.berserk_table_top.model.creature.CreatureRarity;
import com.rpg.berserk_table_top.model.creature.CreatureRisk;
import com.rpg.berserk_table_top.model.creature.CreatureType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreatureNoteRequest {

    private String diaryId;
    private String name;
    private String senses;
    private String behavior;
    private String observation;
    private CreatureType type;
    private CreatureLanguage language;
    private CreatureRarity rarity;
    private CreatureRisk risk;
}