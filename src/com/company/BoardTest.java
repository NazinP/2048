package com.company;

import com.company.models.Board;
import com.company.models.Key;
import com.company.models.SquareBoard;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;

public class BoardTest {
    private final static Board<Key, Integer> board = new SquareBoard<>(4);
    static Random random = new Random();

    public static void main(String[] args) {
        board.fillBoard(asList(1, 2, 3, null));
        if (board.availableSpace().get(0) != board.getKey(1, 1)) {
            throw new RuntimeException("availableSpace not work =(");
        }
        if(board.getKey(0, 0) != board.getKey(0, 0)){
            throw new RuntimeException("Kys must be same!");
        }
        if(board.getKey(2, 2) != null){
            throw new RuntimeException("Not found key must be null");
        }
        if(board.getValue(board.getKey(1, 1)) != null){
            throw new RuntimeException("getValue() not work");
        }
        if(!board.hasValue(null) || !board.hasValue(3)){
            throw new RuntimeException("hasValue not work");
        }
        assertEquals(board.getColumn(0), asList(board.getKey(0, 0), board.getKey(1, 0)));
        assertEquals(board.getRow(0), asList(board.getKey(0, 0), board.getKey(0, 1)));
    }

    public static void assertEquals(List list1, List list2) {
        if(!list1.equals(list2)){
            throw new RuntimeException("List1: " + list1 + " not equals List2: " + list2);
        }
    }
}
