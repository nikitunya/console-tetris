package Figures;


import Enums.FigureType;
import Enums.RotationState;
import Figures.Figure;
import Figures.Point;
import Logic.Board;

public class ShapeZ extends Figure {
    public ShapeZ(FigureType figureType, int x, Board board) {
        super(figureType, board);
        this.points[0] = new Point(x, 2);
        this.points[1] = new Point(x, 1);
        this.points[2] = new Point(x + 1, 1);
        this.points[3] = new Point(x + 1, 0);
    }

    @Override
    public void rotate(Point[] points) {
        switch (rotationState){
            case ANGLE_0:
                points[0].x++;
                points[0].y--;
                points[2].x--;
                points[2].y--;
                points[3].x -= 2;
                break;
            case ANGLE_90:
                points[0].x--;
                points[0].y--;
                points[2].x--;
                points[2].y++;
                points[3].y += 2;
                break;
            case ANGLE_180:
                points[0].x--;
                points[0].y++;
                points[2].x++;
                points[2].y++;
                points[3].x += 2;
                break;
            case ANGLE_270:
                points[0].x++;
                points[0].y++;
                points[2].x++;
                points[2].y--;
                points[3].y -= 2;
                break;
        }
    }
}
