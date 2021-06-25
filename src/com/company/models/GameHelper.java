package com.company.models;

import java.util.*;

public class GameHelper implements Comparator<Integer>{
    public List<Integer> moveAndMergeEquals(List<Integer> list) {
        List<Integer> newLine = new ArrayList<>(list);
        newLine.sort(this::compare);

        for (int i = 1; i < newLine.size(); i++) {
            if (Objects.equals(newLine.get(i), newLine.get(i - 1)) || newLine.get(i) == null){
                continue;
            }
            else{
                int sum = newLine.get(i) + newLine.get(i - 1);
                newLine.set(i - 1, sum);
                newLine.remove(i);
                newLine.add(null);
            }
        }
        return newLine;
    }

    @Override
    public int compare(Integer left, Integer right) {
        if (left.equals(right)) {
            return 0;
        }
        if (left == null) {
            return 1;
        }
        if (right == null) {
            return -1;
        }
        return 0;
    }
}
