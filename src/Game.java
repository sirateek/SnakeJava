import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Game extends JFrame {
    public static int GAME_SPEED = 700;

    private GridUI gridUI;
    private int boardSize = 30;
    private Snake snake;
    private Thread gameThread;
    private boolean isAlive = true;

    public Game() {
        int middle = boardSize / 2;
        gridUI = new GridUI();
        snake = new Snake(middle, middle);
        gameThread = new Thread() {
            @Override
            public void run() {
                while (isAlive) {
                    snake.move();
                    gridUI.repaint();
                    try {
                        Thread.sleep(GAME_SPEED);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        stop();
                    }
                }
            }
        };
        add(gridUI);
        pack();
    }

    public void start() {
        setVisible(true);
        setAlwaysOnTop(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        gameThread.start();
    }

    class GridUI extends JPanel{
        public static final int CELL_PIXEL_SIZE = 30;

        public GridUI() {
            setPreferredSize(new Dimension(boardSize * CELL_PIXEL_SIZE, (boardSize + 2) * CELL_PIXEL_SIZE));
             Game.this.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {

                }

                @Override
                public void keyPressed(KeyEvent e) {
                    int keycode = e.getKeyCode();
                    switch(keycode) {
                        case KeyEvent.VK_UP:
                            snake.moveUp();
                            break;
                        case KeyEvent.VK_DOWN:
                            snake.moveDown();
                            break;
                        case KeyEvent.VK_RIGHT:
                            snake.moveRight();
                            break;
                        case KeyEvent.VK_LEFT:
                            snake.moveLeft();
                            break;
                    }
                }

                @Override
                public void keyReleased(KeyEvent e) {

                }
            });
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            for (int i = 0; i < boardSize; i++) {
                for (int j = 0; j < boardSize; j++) {
                    paintCell(g, i, j);
                }
            }

            // Paint the Snake;
            g.setColor(Color.red);
            g.fillRect(snake.getX() * CELL_PIXEL_SIZE, snake.getY() * CELL_PIXEL_SIZE, CELL_PIXEL_SIZE,
                    CELL_PIXEL_SIZE);

            // Paint snake's tails
            g.setColor(Color.gray);
            for (SnakeTail entity : snake.getTails()) {
                g.fillRect(entity.getX() * CELL_PIXEL_SIZE, entity.getY() * CELL_PIXEL_SIZE, CELL_PIXEL_SIZE,
                        CELL_PIXEL_SIZE);
            }
            repaint();
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
