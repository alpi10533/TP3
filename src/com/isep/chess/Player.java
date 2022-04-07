package com.isep.chess;

/**
 * Class Player
 */
public class Player {

    //
    // Fields
    //
    private final String name ;
    private final int color ;

    //
    // Constructors
    //
    public Player(String name, int color){
        this.name = name ;
        this.color = color ; // 1 = Black | 2 = White
    }

    //
    // Methods
    //
    public String getName() {
        return name;
    }

    public int getColor() {
        return color;
    }

}
