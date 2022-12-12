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
//        this.boardCoordinates[y][x] = true; // TODO: If what bug here may be with placement
    }

    public Figure createFigure() {
        Random random = new Random();
        int placeToSpawn = 7; //TODO: Maybe do it const
        int randomType = random.nextInt(5);
        this.figureType = FigureType.getType(randomType); // TODO: change
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
