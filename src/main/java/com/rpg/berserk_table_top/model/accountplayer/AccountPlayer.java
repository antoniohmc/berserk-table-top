package com.rpg.berserk_table_top.model.accountplayer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "account")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountPlayer {

    @Id
    private String id;
    private String diaryId;

    private String nickname;
    private String password;

}
