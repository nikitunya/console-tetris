package Rendering;

import Enums.MoveType;
import Figures.Figure;
import Figures.Point;
import Logic.Board;
import Logic.InputManager;
import Logic.MoveManager;
import org.junit.Test;

import static org.junit.Assert.*;

public class FigureRendererTest {

    @Test
    public void isFigureMoving() {
        //GIVEN: Game board with a figure
        Board board = new Board();
        FigureRenderer figureRenderer = new FigureRenderer(board);
        MoveManager moveManager = new MoveManager(board);
        Figure figure;
        figure = figureRenderer.createFigure();
        int[] oldY = new int[4];

        Point[] points = figure.getPoints();
        for (int i = 0; i < 4; i++) {
            oldY[i] = points[i].y;
        }

        //WHEN: Figure moves down one move
        moveManager.moveFigure(figure, MoveType.DOWN);

        //THEN: Check if y coordinates has been increased
        for (int i = 0; i < 4; i++) {
            assertEquals(oldY[i]+1, points[i].y);
        }
    }
    @Test
    public void isRemoveOldFigureCoordinates(){
        //GIVEN: Game board with a figure
        Board board = new Board();
        FigureRenderer figureRenderer = new FigureRenderer(board);
        MoveManager moveManager = new MoveManager(board);
        Figure figure;
        figure = figureRenderer.createFigure();

        //WHEN: Game gets input from user and figure moves down
        InputManager inputManager = new InputManager(figure, board);
        inputManager.processUserInput("s");
        boolean[][] map = board.getBoard();
        Point[] points = figure.getPoints();

        //THEN: Check if figure has been reprinted in board
        for (int i = 0; i < 4; i++) {
            assertEquals(false, map[points[i].y][points[i].x]);
        }
    }
    @Test
    public void movesFigureOnUserInput(){
        //GIVEN: Game board with a figure
        Board board = new Board();
        FigureRenderer figureRenderer = new FigureRenderer(board);
        MoveManager moveManager = new MoveManager(board);
        Figure figure;
        figure = figureRenderer.createFigure();
        Point[] points = figure.getPoints();
        int[] oldX = new int[4];
        int[] oldY = new int[4];
        for (int i = 0; i < 4; i++) {
            oldX[i] = points[i].x;
            oldY[i] = points[i].y;
        }
        //WHEN: Game gets input from user and figure moves down
        InputManager inputManager = new InputManager(figure, board);
        inputManager.processUserInput("a");

        //THEN: Check if figure moved correctly based on user input
        for (int i = 0; i < 4; i++) {
            assertEquals(oldX[i]-1, points[i].x);
            assertEquals(oldY[i]+1, points[i].y);
        }
    }
}