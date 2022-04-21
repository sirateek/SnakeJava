import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Game extends JFrame {
    private GridUI gridUI;
    private int boardSize = 30;

    public Game() {
        gridUI = new GridUI();
        add(gridUI);
        pack();
    }

    public void start() {
        setVisible(true);
        setAlwaysOnTop(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    class GridUI extends JPanel {
        public static int CELL_PIXEL_SIZE = 30;

        public GridUI() {
            setPreferredSize(new Dimension(boardSize * CELL_PIXEL_SIZE, (boardSize + 2) * CELL_PIXEL_SIZE));
        }

        public void paintCell(Graphics g, int row, int col) {
            int x = col * CELL_PIXEL_SIZE;
            int y = row * CELL_PIXEL_SIZE;

            g.setColor(Color.gray);
            g.fillRect(x, y, CELL_PIXEL_SIZE, CELL_PIXEL_SIZE);
            g.setColor((Color.lightGray));
            g.fillRect(x + 1, y + 1, CELL_PIXEL_SIZE - 2, CELL_PIXEL_SIZE - 2);

        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}
