package com.rpg.berserk_table_top.exceptions.accountplayer;

public class ExistingNicknameException extends RuntimeException {

    public ExistingNicknameException(String message) {
        super(message);
    }
}
