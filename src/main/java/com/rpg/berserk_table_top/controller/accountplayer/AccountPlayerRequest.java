package com.rpg.berserk_table_top.controller.accountplayer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountPlayerRequest {

    private String diaryId;

    private String nickname;
    private String password;
}
