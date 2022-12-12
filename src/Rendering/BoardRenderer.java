package Rendering;

import Logic.Board;

public class BoardRenderer {

    private Board board;

    public BoardRenderer(Board board) {
        this.board = board;
    }

    public void renderBoard() {
        System.out.println("----------------------");
        for (int i = 0; i < board.getHeight(); i++) {
            System.out.print("*");
            for (int j = 0; j < board.getHeight(); j++) {
                if (board.isStar(j, i)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("*");
        }
        for (int i = 0; i < board.getHeight() + 2; i++) {
            System.out.print("*");
        }
    }
}
