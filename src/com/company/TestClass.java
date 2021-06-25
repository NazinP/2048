package com.company;

import com.company.interfaces.Game;
import com.company.models.Board;
import com.company.models.Game2048;
import com.company.models.Key;
import com.company.models.SquareBoard;

public class TestClass {

    public static void main(String[] args) {
	    Board<Key, Integer> board = new SquareBoard<>(4);
//        Game game2048 = new Game2048(board);
//        System.out.println(game2048.canMove());
    }
}
