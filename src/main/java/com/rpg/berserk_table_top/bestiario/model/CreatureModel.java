package com.rpg.berserk_table_top.bestiario.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatureModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private CreatureType type;

    private Integer armorClass;
    private Integer hitPoints;
    private Integer displacement;

    private Integer strength;
    private Integer dexterity;
    private Integer constitution;
    private Integer intelligence;
    private Integer wisdom;
    private Integer charisma;

    private String resistenceTests;
    private String expertise;
    private String resistenceDamage;
    private String immunitiesToCondition;
    private String senses;
    private CreatureLanguage language;
    private CreatureRarity rarity;


    @OneToMany(cascade = CascadeType.ALL)
    private List<ActionModel> action;


}
