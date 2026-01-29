package com.rpg.berserk_table_top.exeptions.accountplayer;

public class NotFoundAccount extends RuntimeException {

    public NotFoundAccount(String message) {
        super(message);
    }
}
