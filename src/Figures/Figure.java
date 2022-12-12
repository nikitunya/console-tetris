package Figures;


import Enums.FigureType;
import Enums.RotationState;
import Logic.Board;

public abstract class Figure {
    protected static final int FIGURE_SIZE = 4;

    protected FigureType figureType;
    private int lastMove = 0;
    protected Point[] points;
    Board board;
    public RotationState rotationState;

    public Figure(FigureType figureType, Board board){
        this.points = new Point[FIGURE_SIZE];
        this.figureType = figureType;
        this.board = board;
        this.rotationState = RotationState.ANGLE_0;
    }

    public static Figure createFigure(FigureType typeOfFigure, int x, Board parentBoard) {
        switch (typeOfFigure) {
            case Z:
                return new ShapeZ(typeOfFigure, x, parentBoard);
            case I:
                return new ShapeI(typeOfFigure, x, parentBoard);
            case O:
                return new ShapeO(typeOfFigure, x, parentBoard);
            case L:
                return new ShapeL(typeOfFigure, x, parentBoard);
            case J:
                return new ShapeJ(typeOfFigure, x, parentBoard);
        }
        return null;
    }

    public void clear() {
        for (int i = 0; i < FIGURE_SIZE; i++) {
            this.board.clearFigureFromBoard(this.points[i].x, this.points[i].y);
        }
    }
    public int getFigureSize(){
        return FIGURE_SIZE;
    }
    public Point[] getPoints(){
        return points;
    }

    public FigureType getFigureType(){
        return figureType;
    }
    public boolean contains(int x, int y) {
        for (int i = 0; i < points.length; i++) {
            if (points[i].x == x && points[i].y == y) {
                return true;
            }
        }
        return false;
    }

    public abstract void rotate(Point[] points);

    public RotationState getRotationState() {
        return rotationState;
    }

    public void setRotationState(RotationState rotationState) {
        this.rotationState = rotationState;
    }

    public void setFigureType(FigureType figureType) {
        this.figureType = figureType;
    }

    public void setPoints(Point[] points) {
        this.points = points;
    }
}
