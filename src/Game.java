import Figures.Figure;
import Logic.Board;
import Logic.InputManager;
import Logic.MoveManager;
import Logic.TextManager;
import Rendering.BoardRenderer;
import Rendering.FigureRenderer;

public class Game {
    public static void startGame(){
        boolean gameOver = false;
        Board board = new Board();
        BoardRenderer boardRenderer = new BoardRenderer(board);
        InputManager inputManager;
        MoveManager moveManager = new MoveManager(board);
        FigureRenderer figureRenderer = new FigureRenderer(board);
        TextManager textManager = new TextManager();
        Figure figure = figureRenderer.createFigure();
        boardRenderer.renderBoard();
        while (moveManager.canMove(figure) && !gameOver){
            while (true){
                inputManager = new InputManager(figure, board);
                inputManager.processUserInput(inputManager.getUserChoice());
                boardRenderer.renderBoard();
                if (!moveManager.canMove(figure))
                    break;
            }
            gameOver = board.gameOver();
            textManager.emptyLine();
            board.checkForRemoval();
            figure = figureRenderer.createFigure();
            boardRenderer.renderBoard();
            textManager.score(board.getScore());
        }
        textManager.gameOverText();
    }
}
