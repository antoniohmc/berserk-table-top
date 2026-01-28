package com.rpg.berserk_table_top.model.creature;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatureNote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String senses;
    private String behavior;
    private List<String> observation;

    private CreatureType type;
    private CreatureLanguage language;
    private CreatureRarity rarity;
    private CreatureRisk risk;



}
