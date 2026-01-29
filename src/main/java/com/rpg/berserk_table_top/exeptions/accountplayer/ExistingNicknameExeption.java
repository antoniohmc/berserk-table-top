package com.rpg.berserk_table_top.exeptions.accountplayer;

public class ExistingNicknameExeption extends RuntimeException {

    public ExistingNicknameExeption(String message) {
        super(message);
    }
}
