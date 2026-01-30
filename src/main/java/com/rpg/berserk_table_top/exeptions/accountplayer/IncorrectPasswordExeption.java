package com.rpg.berserk_table_top.exeptions.accountplayer;

public class IncorrectPasswordExeption extends RuntimeException {

    public IncorrectPasswordExeption(String message) {
        super(message);
    }
}
