package Logic;

import Figures.Figure;

public class Board {

    private static final int BOARD_SIZE = 15;
    private boolean board[][];
    private int score;

    public Board() {
        this.board = new boolean[BOARD_SIZE][BOARD_SIZE];
        this.score = 0;
    }

    public boolean notOutBounds(int x, int y){
        if(x < 0 || x > BOARD_SIZE - 1 || y < 0 || y > BOARD_SIZE - 1)
            return false;
        return true;
    }
    public boolean notOutBounds(int x, int y, Figure figure){
        if(x < 0 || x > BOARD_SIZE - 1 || y < 0 || y > BOARD_SIZE - 1)
            return false;
        return !board[x][y] || figure.contains(x, y);
    }
    private void removeRow(int row) {
        for (int i = row; i > 0; i--) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[j][i] = board[j][i - 1];
            }
        }
        for (int i = 0; i < BOARD_SIZE; i++) {
            board[i][0] = false;
        }
        score += 1000;
    }

    public void checkForRemoval() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            boolean isRowFull = true;
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[j][i] == false) {
                    isRowFull = false;
                    break;
                }
            }
            if (isRowFull) {
                removeRow(i);
            }
        }
    }
    public void clearFigureFromBoard(int x, int y) {
        this.board[x][y] = false;
    }
    public int getHeight(){
        return BOARD_SIZE;
    }
    public boolean isStar(int x, int y){
        return board[x][y] == true;
    }

    public boolean[][] getBoard(){
        return board;
    }

    public int getScore() {
        return score;
    }
    public boolean gameOver(){
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[i][1] == true){
                return true;
            }
        }
        return false;
    }
}
