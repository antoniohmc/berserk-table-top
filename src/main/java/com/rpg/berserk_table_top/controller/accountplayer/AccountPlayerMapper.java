package com.rpg.berserk_table_top.controller.accountplayer;

import com.rpg.berserk_table_top.model.accountplayer.AccountPlayer;

public class AccountPlayerMapper {

    static AccountPlayerResponse mapToResponse(AccountPlayer accountPlayer) {
        return AccountPlayerResponse.builder()
                .id(accountPlayer.getId())
                .diaryId(accountPlayer.getDiaryId())
                .nickname(accountPlayer.getNickname())
                .password(accountPlayer.getPassword())
                .build();
    }

    static AccountPlayer mapToEntity(AccountPlayerRequest accountPlayerRequest) {
        return AccountPlayer.builder()
                .diaryId(accountPlayerRequest.getDiaryId())
                .nickname(accountPlayerRequest.getNickname())
                .password(accountPlayerRequest.getPassword())
                .build();
    }
}
