import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Game implements ActionListener {
    private Brick[] bricks;
    private Ball ball;
    private Rectangle bounds;
    private GamePanel gamePanel;
    private Timer timer;

    public Game(Brick[] bricks, Ball ball, Rectangle bounds) {
        this.bricks = bricks;
        this.ball = ball;
        this.bounds = bounds;
        this.gamePanel = new GamePanel(bricks, ball, bounds);
        this.timer = new Timer(10, this);
    }

    public void start() {
        JFrame frame = new JFrame("Brick Breaker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(gamePanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Move ball
        ball.move();

        // Check for collisions
        boolean destroyed = gamePanel.handleCollision();
        if (destroyed) {
            checkForWin();
        }

        // Move moving bricks
        for (Brick brick : bricks) {
            if (brick instanceof MovingBrick) {
                ((MovingBrick) brick).move(bounds);
            }
            if (brick instanceof AcceleratingBrick) {
                ((AcceleratingBrick) brick).accelerate(1);
                ((AcceleratingBrick) brick).move();
            }
        }

        // Repaint panel
        gamePanel.repaint();
    }

    private void checkForWin() {
        if (gamePanel.bricksRemaining == 0) {
            JOptionPane.showMessageDialog(gamePanel, "You win!");
            System.exit(0);
        }
    }

    private static Brick[] createBricks(int rows, int cols, int width, int height, int gap) {


        Brick[] bricks = new Brick[rows * cols];
        // Create controlled brick
        ControlledBrick controlledBrick = new ControlledBrick(new Point(300, 550), new Dimension(100, 20), 5);
        bricks[bricks.length - 1] = controlledBrick;
        Random random = new Random();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int x = col * (width + gap) + gap;
                int y = row * (height + gap) + gap;
                int health = random.nextInt(3) + 1; // 1~3 사이의 랜덤한 체력
                if (health == 1) {
                    int newBrick = (int) (Math.random()*4 +1);
                    if(newBrick == 1){
                        bricks[row * cols + col] = new SimpleBrick(new Point(x, y), new Dimension(width, height));
                    } else if(newBrick == 2){
                        bricks[row * cols + col] = new SolidBrick(new Point(x, y), new Dimension(width, height));
                    } else if (newBrick == 3) {
                        bricks[row * cols + col] = new AcceleratingBrick(new Point(x, y), new Dimension(width, height),3);
                    } else if (newBrick == 4) {
                        bricks[row * cols + col] = new SolidBrick(new Point(x, y), new Dimension(width, height));
                    }
//                    bricks[row * cols + col] = new SimpleBrick(new Point(x, y), new Dimension(width, height));
                } else {
                    bricks[row * cols + col] = new WeakBrick(new Point(x, y), new Dimension(width, height), health);
                }
            }
        }
        return bricks;
    }



    public static void main(String[] args) {
        Brick[] bricks = createBricks(5, 16, 50, 20, 2);
        Ball ball = new Ball(new Point(300, 400), new Dimension(20, 20), 45, 5);
        Rectangle bounds = new Rectangle(0, 0, 800, 600);
        Game game = new Game(bricks, ball, bounds);
        game.start();
    }
}
