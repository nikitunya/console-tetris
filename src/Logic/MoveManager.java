package Logic;

import Enums.MoveType;
import Enums.RotationState;
import Figures.Figure;
import Figures.Point;
import Rendering.FigureRenderer;

public class MoveManager {

    private Board board;
    FigureRenderer figureRenderer;

    public MoveManager(Board board) {
        this.board = board;
        this.figureRenderer =  new FigureRenderer(board);
    }

    public void moveFigure(Figure figure, MoveType moveType){
        if (moveType == MoveType.ROTATE && canRotate(figure) && canMove(figure)){
            figure.clear();
            makeMove(moveType, figure);
            moveDown(figure);
            figureRenderer.draw(figure);
        }else if(moveType == MoveType.DOWN && canMove(moveType, figure)){
            figure.clear();
            makeMove(moveType, figure);
            moveDown(figure);
            figureRenderer.draw(figure);
        } else if(canMove(moveType, figure) && moveType != MoveType.ROTATE && canMove(figure)){
            figure.clear();
            makeMove(moveType, figure);
            moveDown(figure);
            figureRenderer.draw(figure);
        }
    }

    private void makeMove(MoveType moveType, Figure figure){
        Point[] points = figure.getPoints();
        switch (moveType){
            case LEFT:
                moveLeft(points, figure);
                break;
            case RIGHT:
                moveRight(points, figure);
                break;
            case ROTATE:
                figure.rotate(points);
                int rotationStateTemp = figure.getRotationState().ordinal();
                rotationStateTemp++;
                if (rotationStateTemp > 3) {
                    rotationStateTemp = 0;
                }
                figure.setRotationState(RotationState.getType(rotationStateTemp));
                break;
        }
    }

    private boolean canRotate(Figure figure){
        Point[] points = figure.getPoints();
        Point[] tempPoints = new Point[figure.getFigureSize()];

        for (int i = 0; i < figure.getFigureSize(); i++) {
            tempPoints[i] = new Point(points[i].x, points[i].y);
        }

        figure.rotate(tempPoints); // TODO: Padaryt

        for (int i = 0; i < figure.getFigureSize(); i++) {
            if (!board.notOutBounds(tempPoints[i].y, tempPoints[i].x)) {
                return false;
            }
        }

        return true;
    }

    public boolean canMove(Figure figure){
        Point[] points = figure.getPoints();

        Point[] tempPoints = new Point[figure.getFigureSize()];
        for (int i = 0; i < figure.getFigureSize(); i++) {
            tempPoints[i] = new Point(points[i].x, points[i].y);
        }
        checkMoveDown(tempPoints, figure);
        for (int i = 0; i < tempPoints.length; i++) { //TODO: Here is exctra code
            if (!board.notOutBounds(tempPoints[i].x, tempPoints[i].y, figure)) {
                return false;
            }
        }

        if (canMove(MoveType.LEFT, figure) || canMove(MoveType.RIGHT, figure)){
            return true;
        }
        return false;
    }

    public boolean canMove(MoveType moveType, Figure figure){
        Point[] points = figure.getPoints();

        Point[] tempPoints = new Point[figure.getFigureSize()];
        for (int i = 0; i < figure.getFigureSize(); i++) {
            tempPoints[i] = new Point(points[i].x, points[i].y);
        }

        switch (moveType) {
            case LEFT:
                moveLeft(tempPoints, figure);
                break;
            case RIGHT:
                moveRight(tempPoints, figure);
                break;
            case DOWN:
                checkMoveDown(tempPoints, figure);
                break;
        }
        for (int i = 0; i < tempPoints.length; i++) {
            if (!board.notOutBounds(tempPoints[i].x, tempPoints[i].y)) {
                return false;
            }
        }
        return true;
    }

    private void moveLeft(Point[] tempPoints, Figure figure) {
        for (int i = 0; i < figure.getFigureSize(); i++) {
            tempPoints[i].x--;
        }
    }
    private void moveRight(Point[] tempPoints, Figure figure) {
        for (int i = 0; i < figure.getFigureSize(); i++) {
            tempPoints[i].x++;
        }
    }

    private void moveDown(Figure figure){
        Point[] points = figure.getPoints();
        for (int i = 0; i < figure.getFigureSize(); i++) {
            points[i].y++;
        }
    }

    public void checkMoveDown(Point[] tempPoints, Figure figure){
        for (int i = 0; i < figure.getFigureSize(); i++) {
            tempPoints[i].y++;
        }
    }
//    protected abstract void rotate(Point[] points);
}
