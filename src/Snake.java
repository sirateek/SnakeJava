import java.util.ArrayList;
import java.util.List;

public class Snake extends Entity {
    public static int INITIAL_TAIL_SIZE = 3;
    private int dx;
    private int dy;

    private List<SnakeTail> tails = new ArrayList<SnakeTail>();

    public Snake(int x, int y) {
        super(x, y);
        // Always start moving to the right first
        dx = 1;
        dy = 0;

        // Start with tails from the configured value;
        for (int i = 1; i < INITIAL_TAIL_SIZE + 1; i++) {
            tails.add(new SnakeTail(x - i, y));
        }

    }

    public void move() {
        // Update the entire tails
        int tailSize = tails.size();

        for (int i = tailSize - 1; i > 0; i--) {
            SnakeTail currentTail = tails.get(i);
            SnakeTail nextTail = tails.get(i - 1);
            currentTail.setX(nextTail.getX());
            currentTail.setY(nextTail.getY());
        }

        SnakeTail headMost = tails.get(0);
        headMost.setX(getX());
        headMost.setY(getY());
        // Update the current possition with dx,dy;
        this.setX(this.getX() + dx);
        this.setY(this.getY() + dy);
    }

    public void moveLeft() {
        dx = -1;
        dy = 0;
    }

    public void moveRight() {
        dx = 1;
        dy = 0;
    }

    public void moveUp() {
        dx = 0;
        dy = -1;
    }

    public void moveDown() {
        dx = 0;
        dy = 1;
    }

    public List<SnakeTail> getTails() {
        return this.tails;
    }
}
