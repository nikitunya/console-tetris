package Logic;

public class TextManager {
    public void enterMove(){
        System.out.println();
        System.out.print("Enter move: ");
    }
    public void score(int score){
        System.out.println();
        System.out.println("Score: " + score);
    }
    public void emptyLine(){
        System.out.println();
    }
    public void gameOverText(){
        System.out.println("---------");
        System.out.println("Game over");
        System.out.println("---------");
    }
}
