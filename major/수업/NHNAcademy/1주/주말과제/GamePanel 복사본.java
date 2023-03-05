import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private Brick[] bricks;
    Ball ball;
    private Rectangle bounds;
    private int score;
    private int bounces;
    int bricksRemaining;

    public GamePanel(Brick[] bricks, Ball ball, Rectangle bounds) {
        this.bricks = bricks;
        this.ball = ball;
        this.bounds = bounds;
        this.score = 0;
        this.bounces = 0;
        this.bricksRemaining = bricks.length;

        // Set up panel
        setPreferredSize(new Dimension(bounds.width, bounds.height));
        setOpaque(true);
        setBackground(Color.WHITE);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw bricks
        for (Brick brick : bricks) {
            brick.draw(g);
        }

        // Draw ball
        g.setColor(Color.BLACK);
        g.fillOval((int) ball.getX(), (int) ball.getY(), (int) ball.getWidth(), (int) ball.getHeight());

        // Draw bounds
        g.setColor(Color.GRAY);
        g.drawRect(bounds.x, bounds.y, bounds.width, bounds.height);

        // Draw score and bounces
        g.setColor(Color.BLACK);
        g.drawString("Score: " + score, 10, 20);
        g.drawString("Bounces: " + bounces, 10, 40);
        g.drawString("Bricks remaining: " + bricksRemaining, 10, 60);
    }

    /**
     * Handles a collision between the ball and a brick or the bounds.
     *
     * @return true if the ball hit a brick and the brick was destroyed, false otherwise
     */
    public boolean handleCollision() {
        boolean destroyed = false;

        // Check for collision with bounds
        if (ball.getX() < bounds.x || ball.getX() + ball.getWidth() > bounds.x + bounds.width) {
            ball.reflect(0);
            bounces++;
        }
        if (ball.getY() < bounds.y) {
            ball.reflect(1);
            bounces++;
        } else if (ball.getY() + ball.getHeight() > bounds.y + bounds.height) {
            JOptionPane.showMessageDialog(this, "Game over!");
            System.exit(0);
        }

        // Check for collision with bricks
        for (int i = 0; i < bricks.length; i++) {
            Brick brick = bricks[i];
            Rectangle brickRect = new Rectangle(brick.getPosition(), brick.getSize());
            if (ball.intersects(brickRect)) {
                boolean destroyedThisBrick = brick.handleCollision();
                if (destroyedThisBrick) {
                    score += 10;
                    bricksRemaining--;
                }
                destroyed = destroyed || destroyedThisBrick;

                // Reflect ball
                int x = (int) ball.getX();
                int y = (int) ball.getY();
                int dx = (x < brickRect.x) ? -1 : (x > brickRect.x + brickRect.width) ? 1 : 0;
                int dy = (y < brickRect.y) ? -1 : (y > brickRect.y + brickRect.height) ? 1 : 0;
                ball.reflect(dx != 0 ? 0 : 1);
                bounces++;

                // Change ball angle based on where it hit the brick
                ball.changeAngle(x);
            }
        }

        return destroyed;
    }
}