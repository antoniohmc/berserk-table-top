package com.rpg.berserk_table_top.controller.diary;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DiaryRequest {

    private String name;
    private String accountPlayerId;
    private List<String> creatureNotesId;
    private List<String> notesId;
}
