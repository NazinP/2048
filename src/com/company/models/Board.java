package com.company.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Board {
    int width;
    int height;
    Map<Key, Integer> board = new HashMap<>();

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public abstract void fillBoard(List<Integer> list);
    public abstract List<Key> availableSpace();
    public abstract void addItem(Key key, Integer value);
    public abstract Key getKey(int row, int col);
    public abstract Integer getValue(Key key);
    public abstract List<Key> getColumn(int col);
    public abstract List<Key> getRow(int row);
    public abstract boolean hasValue(Integer value);
    public abstract List<Integer> getValues(List<Key> keys);

}
