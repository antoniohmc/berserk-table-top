package com.rpg.berserk_table_top.model.creature;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document (collection = "note")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatureRumor {

    @Id
    private String id;

    private String accountantName;
    private CreatureHabitat habitat;
    private List<String> darkTales;
    private String immunitiesToCondition;
    private String resistenceDamage;


}
