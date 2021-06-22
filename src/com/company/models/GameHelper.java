package com.company.models;

import java.util.*;

import static java.util.Comparator.*;

public class GameHelper {
    public List<Integer> moveAndMergeEquals(List<Integer> list) {
        List<Integer> newLine = new ArrayList<>(list);
        for (int i = 1; i < list.size(); i++) {
            if (newLine.get(i) != null && Objects.equals(newLine.get(i), newLine.get(i - 1))) {
                int sum = list.get(i) * 2;
                newLine.set(i - 1, sum);
                newLine.remove(i);
                newLine.add(null);
            } else if (newLine.get(i - 1) == null) {
                newLine.set(i - 1, newLine.get(i));
                newLine.remove(i);
                newLine.add(null);
            }
        }
        return newLine;
    }
}
