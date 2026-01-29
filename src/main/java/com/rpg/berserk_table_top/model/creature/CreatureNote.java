package com.rpg.berserk_table_top.model.creature;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "creature")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreatureNote {

    @Id
    private String id;
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
