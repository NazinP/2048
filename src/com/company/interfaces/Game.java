package com.company.interfaces;

import com.company.models.Board;
import com.company.models.Direction;

public interface Game {
    void init();
    boolean canMove();
    boolean move(Direction direction);
    void addItem();
    Board getGameBoard();
    boolean hasWin();
}
