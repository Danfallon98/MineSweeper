package com.example.minesweeper;

import java.util.Random;

public class MinefieldArray{

    public static MinefieldArray instance = null;

    private MinefieldArray(){

    }

    //Instance of minefield array
    public static MinefieldArray getInstance(){
        if (instance == null){
            instance = new MinefieldArray();

        }
        return instance;
    }

    //cell states
    public static final int Covered = 0;
    public static final int Empty = 1;
    public static final int Mine = 2;
    public static final int Revealed = 3;
    public static final int Flagged = 4;
    public static final int Uncovered = 5;

    private int action = Revealed;

    //model for board
    public int [][] board = {
            {Empty,Empty,Empty,Empty,Empty,Empty,Empty,Empty,Empty,Empty},
            {Empty,Empty,Empty,Empty,Empty,Empty,Empty,Empty,Empty,Empty},
            {Empty,Empty,Empty,Empty,Empty,Empty,Empty,Empty,Empty,Empty},
            {Empty,Empty,Empty,Empty,Empty,Empty,Empty,Empty,Empty,Empty},
            {Empty,Empty,Empty,Empty,Empty,Empty,Empty,Empty,Empty,Empty},
            {Empty,Empty,Empty,Empty,Empty,Empty,Empty,Empty,Empty,Empty},
            {Empty,Empty,Empty,Empty,Empty,Empty,Empty,Empty,Empty,Empty},
            {Empty,Empty,Empty,Empty,Empty,Empty,Empty,Empty,Empty,Empty},
            {Empty,Empty,Empty,Empty,Empty,Empty,Empty,Empty,Empty,Empty},
            {Empty,Empty,Empty,Empty,Empty,Empty,Empty,Empty,Empty,Empty}
    };

    //model for covered board
    private int [][] coveredBoard = {
            {Covered,Covered,Covered,Covered,Covered,Covered,Covered,Covered,Covered,Covered},
            {Covered,Covered,Covered,Covered,Covered,Covered,Covered,Covered,Covered,Covered},
            {Covered,Covered,Covered,Covered,Covered,Covered,Covered,Covered,Covered,Covered},
            {Covered,Covered,Covered,Covered,Covered,Covered,Covered,Covered,Covered,Covered},
            {Covered,Covered,Covered,Covered,Covered,Covered,Covered,Covered,Covered,Covered},
            {Covered,Covered,Covered,Covered,Covered,Covered,Covered,Covered,Covered,Covered},
            {Covered,Covered,Covered,Covered,Covered,Covered,Covered,Covered,Covered,Covered},
            {Covered,Covered,Covered,Covered,Covered,Covered,Covered,Covered,Covered,Covered},
            {Covered,Covered,Covered,Covered,Covered,Covered,Covered,Covered,Covered,Covered},
            {Covered,Covered,Covered,Covered,Covered,Covered,Covered,Covered,Covered,Covered}
    };

    //state of board
    public int getBoardCell(int x, int y){
        return board[x][y];
    }

    //state of covered board
    public int getCoveredCell(int x, int y){
        return coveredBoard[x][y];
    }

    //set board cover state
    public int setBoardState(int x, int y, int content){
        return board[x][y] = content;
    }

    //set covered board state
    public int setCoveredState(int x, int y, int content){
        return coveredBoard[x][y] = content;
    }

    public int getActionType(){
        return action;
    }

    //return covered
    public int getCovered(){
        return Covered;
    }

    //return uncovered
    public int getUncovered(){
        return Uncovered;
    }












}