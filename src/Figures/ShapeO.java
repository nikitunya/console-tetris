package Figures;


import Enums.FigureType;
import Enums.RotationState;
import Logic.Board;

public class ShapeO extends Figure{
    public ShapeO(FigureType figureType, int x, Board board) {
        super(figureType, board);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.points[i * 2 + j] = new Point(x + i, j);
            }
        }
    }

    @Override
    public void rotate(Point[] points) {

    }
}
