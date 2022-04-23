import java.util.Random;

public class Food extends Entity{
    Random rand = new Random();
    private int boardSize;
    private int x;
    private int y;

    public Food(int boardSize) {
        this.boardSize = boardSize;
        x = rand.nextInt(boardSize);
        y = rand.nextInt(boardSize);
    }

    public void generate() {
        x = rand.nextInt(boardSize);
        y = rand.nextInt(boardSize);
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
}
