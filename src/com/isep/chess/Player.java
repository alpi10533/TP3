package com.isep.chess;

public class Player {

    private final String name ;
    private final int color ;

    public Player(String name, int color){
        this.name = name ;
        this.color = color ; // 1 = Black | 2 = White
    }

    public String getName() {
        return name;
    }

    public int getColor() {
        return color;
    }

}
