package com.rpg.berserk_table_top.model.diary;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "diary")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Diary {

    @Id
    private String id;
    private String name;
    private String accountPlayerId;
    private List<String> creatureNotesId = new ArrayList<>();
    private List<String> notesId = new ArrayList<>();

}
