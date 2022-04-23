import java.util.Random;

public class Food extends Entity{
    Random rand = new Random();
    private int boardSize;

    public Food(int boardSize) {
        this.boardSize = boardSize;
        setX(rand.nextInt(boardSize));
        setY(rand.nextInt(boardSize));
    }

    public void generate() {
        setX(rand.nextInt(boardSize));
        setY(rand.nextInt(boardSize));
    }

}
