package com.company.models;

import com.company.interfaces.Game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Game2048 implements Game {
    public static final int GAME_SIZE = 4;
    private final Board<Key, Integer> board = new SquareBoard<>(GAME_SIZE);
    GameHelper helper = new GameHelper();
    Random random = new Random();

    @Override
    public void init() {
        int size = GAME_SIZE * GAME_SIZE;
        List<Integer> intValues = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            intValues.add(null);
        }
        board.fillBoard(intValues);

        addItem();
        addItem();
    }

    // Если не пустой то можно сделать ход
    @Override
    public boolean canMove() {
        return !board.availableSpace().isEmpty();
    }

    @Override
    public boolean move(Direction direction) {
        if(canMove()){
            if (direction.equals(Direction.LEFT) || direction.equals(Direction.RIGHT)){
                for (int i = 0; i < board.height; i++) {
                    List<Key> keys = board.getRow(i);
                    List<Integer> values = board.getValues(keys);
                    helper.moveAndMergeEquals(values);
                    addItem();
                }
            }else {
                for (int i = 0; i < board.width; i++) {
                    List<Key> keys = board.getColumn(i);
                    List<Integer> values = board.getValues(keys);
                    helper.moveAndMergeEquals(values);
                    addItem();
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public void addItem() {
        Integer cellValue = 0;
        double randomValue = Math.random();
        if (randomValue <= 0.1) {
            cellValue = 4;
        } else if (randomValue <= 0.9 || randomValue > 0.1) {
            cellValue = 2;
        }
        Key key = board.availableSpace().get(random.nextInt(GAME_SIZE));
        board.addItem(key, cellValue);
    }

    @Override
    public Board getGameBoard() {
        return board;
    }

    @Override
    public boolean hasWin() {
        return true;
    }
}
