package com.company.models;

import java.util.Comparator;

public class RowComparator implements Comparator<Key> {
    @Override
    public int compare(Key o1, Key o2) {
        return Integer.compare(o1.getCol(), o2.getCol());
    }
}
