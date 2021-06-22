package com.company.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SquareBoard extends Board {
    private int size;

    public SquareBoard(int size) {
        super(size, size);
        this.size = size;
    }

    @Override
    public void fillBoard(List<Integer> list) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int index = i * size + j;
                Key key = new Key(i, j);
                addItem(key, list.get(index));
            }
        }
    }

    @Override
    public List<Key> availableSpace() {
        return board.keySet().stream()
                .filter(key -> board.get(key) == null)
                .collect(Collectors.toList());
    }

    @Override
    public void addItem(Key key, Integer value) {
        board.put(key, value);
    }

    @Override
    public Key getKey(int row, int col) {
        return board.keySet().stream()
                .filter(key -> key.getRow() == row && key.getCol() == col)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Integer getValue(Key key) {
        return board.get(key);
    }

    @Override
    public List<Key> getColumn(int col) {
        return board.keySet().stream().sorted(new ColComparator())
                .filter(key -> key.getCol() == col)
                .collect(Collectors.toList());
    }

    @Override
    public List<Key> getRow(int row) {
        return board.keySet().stream().sorted(new RowComparator())
                .filter(key -> key.getRow() == row)
                .collect(Collectors.toList());
    }

    @Override
    public boolean hasValue(Integer value) {
        return board.values().stream()
                .anyMatch(integer -> Objects.equals(value, integer));
    }

    @Override
    public List<Integer> getValues(List<Key> keys) {
        return board.keySet().stream()
                .map(board::get)
                .collect(Collectors.toList());
    }
}
