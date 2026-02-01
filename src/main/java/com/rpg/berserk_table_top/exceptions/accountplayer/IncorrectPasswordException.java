package com.rpg.berserk_table_top.exceptions.accountplayer;

public class IncorrectPasswordException extends RuntimeException {

    public IncorrectPasswordException(String message) {
        super(message);
    }
}
