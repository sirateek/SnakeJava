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
        // TODO: Implement the move
        // 1. Update the current possition with dx,dy;
        // 2. Update the entire tails
    }

    public List<SnakeTail> getTrails() {
        return this.tails;
    }
}
