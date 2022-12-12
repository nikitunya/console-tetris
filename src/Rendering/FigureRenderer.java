package Rendering;

import Enums.FigureType;
import Figures.Figure;
import Figures.Point;
import Logic.Board;

import java.util.Random;

public class FigureRenderer {
    private Board board;
    private boolean[][] boardCoordinates;
    private Point[] points;
    private FigureType figureType;
    private Figure figure;


    public FigureRenderer(Board board) {
        this.board = board;
        this.boardCoordinates = board.getBoard();
    }

    public void renderFigure(Figure figure){
        points = figure.getPoints();
        for (int i = 0; i < figure.getFigureSize(); i++) {
            addFigureToBoard(points[i].x, points[i].y);
        }
    }

    public void addFigureToBoard(int x, int y) {
        this.boardCoordinates[x][y] = true;
    }

    public Figure createFigure() {
        Random random = new Random();
        int placeToSpawn = 7;
        int randomType = random.nextInt(5);
        this.figureType = FigureType.getType(randomType);
        figure = Figure.createFigure(figureType, placeToSpawn, board);
        draw(figure);
        return figure;
    }
    public void draw(Figure figure) {
        Point[] points = figure.getPoints();
        for (int i = 0; i < figure.getFigureSize(); i++) {
            addFigureToBoard(points[i].x, points[i].y);
        }
    }
}
