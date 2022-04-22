import java.util.Random;

public class Food {
    Random rand = new Random();
    private boolean eaten;
    private int boardSize;
    private int row;
    private int col;

    public Food(int boardSize) {
        this.boardSize = boardSize;
        this.row = rand.nextInt(boardSize);
        this.col = rand.nextInt(boardSize);
        eaten = true;
    }

    public void generate() {
        row = rand.nextInt(boardSize);
        col = rand.nextInt(boardSize);
    }

    public void setEaten() {
        this.eaten = !this.eaten;
    }

    public boolean isEaten() {
        return eaten;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
