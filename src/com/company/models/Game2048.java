package com.company.models;

import com.company.interfaces.Game;

import java.util.*;

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
        boolean hasSpace = !board.availableSpace().isEmpty();
        boolean hasMoveInFuture = false;
        if(board.availableSpace().size() == 1){
            for (Direction direction : Direction.values()) {
                hasMoveInFuture |= move(direction);
            }
            return hasMoveInFuture;
        }
        return hasSpace;
    }

    @Override
    public boolean move(Direction direction) {
        boolean moved = false;
        switch (direction) {
            case UP:
                for (int i = 0; i < GAME_SIZE; i++) {
                    moved |= moveLine(board.getColumn(i));
                }
                break;
            case RIGHT:
                for (int i = 0; i < GAME_SIZE; i++) {
                    List<Key> keys = board.getRow(i);
                    Collections.reverse(keys);
                    moved |= moveLine(keys);
                }
                break;
            case DOWN:
                for (int i = 0; i < GAME_SIZE; i++) {
                    List<Key> keys = board.getColumn(i);
                    Collections.reverse(keys);
                    moved |= moveLine(keys);
                }
                break;
            case LEFT:
                for (int i = 0; i < GAME_SIZE; i++) {
                    moved |= moveLine(board.getRow(i));
                }
                break;
        }
        if (moved) {
            addItem();
        }
        return true;
    }

    private boolean moveLine(List<Key> keys) {
        List<Integer> values = board.getValues(keys);
        List<Integer> mergedValues = helper.moveAndMergeEquals(values);
        if (!values.equals(mergedValues)) {
            Iterator<Integer> iter = mergedValues.iterator();
            for (Key key : keys) {
                board.addItem(key, iter.next());
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
        List<Key> keys = board.availableSpace();
        Key key = keys.get(random.nextInt(Math.min(GAME_SIZE - 1, keys.size() - 1)));
        board.addItem(key, cellValue);
    }

    @Override
    public Board getGameBoard() {
        return board;
    }

    @Override
    public boolean hasWin() {
        return board.hasValue(64);
    }
}
