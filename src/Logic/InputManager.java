package Logic;

import Enums.MoveType;
import Figures.Figure;

import java.util.Scanner;

public class InputManager {

    Figure figure;
    MoveManager moveManager;
    TextManager textManager = new TextManager();

    public InputManager(Figure figure, Board board) {
        this.figure = figure;
        this.moveManager = new MoveManager(board);
    }

    public void processUserInput(String userInput){
        switch (userInput){
            case "a":
                moveManager.moveFigure(figure, MoveType.LEFT);
                break;
            case "d":
                moveManager.moveFigure(figure, MoveType.RIGHT);
                break;
            case "s":
                moveManager.moveFigure(figure, MoveType.DOWN);
                break;
            case "x":
                moveManager.moveFigure(figure, MoveType.ROTATE);
                break;
        }
    }

    public String getUserChoice(){
        textManager.enterMove();
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
