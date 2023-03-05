import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

interface Brick {
    boolean isDestroyed();
    int getScore();
    void hit();
    void setPosition(int x, int y);
    Rectangle getBounds();
    void move(int x, int y);
}

class SimpleBrick implements Brick {
    private boolean destroyed;
    private final int score;
    private final Rectangle bounds;

    public SimpleBrick(int x, int y, int width, int height, int score) {
        this.bounds = new Rectangle(x, y, width, height);
        this.score = score;
    }

    @Override
    public boolean isDestroyed() {
        return destroyed;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public void hit() {
        destroyed = true;
    }

    @Override
    public void setPosition(int x, int y) {
        bounds.setLocation(x, y);
    }

    @Override
    public Rectangle getBounds() {
        return bounds;
    }

    @Override
    public void move(int x, int y) {
        bounds.translate(x, y);
    }
}

class HardBrick implements Brick {
    private boolean destroyed;
    private int hitCount;
    private final int score;
    private final Rectangle bounds;

    public HardBrick(int x, int y, int width, int height, int score) {
        this.bounds = new Rectangle(x, y, width, height);
        this.score = score;
    }

    @Override
    public boolean isDestroyed() {
        return destroyed;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public void hit() {
        hitCount++;
        if (hitCount == 2) {
            destroyed = true;
        }
    }

    @Override
    public void setPosition(int x, int y) {
        bounds.setLocation(x, y);
    }

    @Override
    public Rectangle getBounds() {
        return bounds;
    }

    @Override
    public void move(int x, int y) {
        bounds.translate(x, y);
    }
}

class UnbreakableBrick implements Brick {
    private final int score;
    private final Rectangle bounds;

    public UnbreakableBrick(int x, int y, int width, int height, int score) {
        this.bounds = new Rectangle(x, y, width, height);
        this.score = score;
    }

    @Override
    public boolean isDestroyed() {
        return false;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public void hit() {
        // Do nothing
    }

    @Override
    public void setPosition(int x, int y) {
        bounds.setLocation(x, y);
    }

    @Override
    public Rectangle getBounds() {
        return bounds;
    }

    @Override
    public void move(int x, int y) {
        bounds.translate(x, y);
    }
}

class MovingBrick implements Brick {
    private boolean destroyed;
    private final int score;
    private final Rectangle bounds;
    private int direction = 1;

    public MovingBrick(int x, int y, int width, int height, int score) {
        this.bounds = new Rectangle(x, y, width, height);
        this.score = score;
    }

    @Override
    public boolean isDestroyed() {
        return destroyed;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public void hit() {
        destroyed = true;
    }

    @Override
    public void setPosition(int x, int y) {
        bounds.setLocation(x, y);
    }

    @Override
    public Rectangle getBounds() {
        return bounds;
    }

    @Override
    public void move(int x, int y) {
        bounds.translate(x * direction, y);
        if (bounds.x <= 0 || bounds.x + bounds.width >= BrickBreakerGame.WIDTH) {
            direction *= -1;
        }
    }
}

class AcceleratingBrick implements Brick {
    private boolean destroyed;
    private final int score;
    private final Rectangle bounds;
    private final int acceleration;

    public AcceleratingBrick(int x, int y, int width, int height, int score, int acceleration) {
        this.bounds = new Rectangle(x, y, width, height);
        this.score = score;
        this.acceleration = acceleration;
    }

    @Override
    public boolean isDestroyed() {
        return destroyed;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public void hit() {
        destroyed = true;
    }

    @Override
    public void setPosition(int x, int y) {
        bounds.setLocation(x, y);
    }

    @Override
    public Rectangle getBounds() {
        return bounds;
    }

    @Override
    public void move(int x, int y) {
        bounds.translate(x, y + acceleration);
    }
}

class ControlBrick implements Brick {
    private boolean destroyed;
    private final int score;
    private final Rectangle bounds;
    private int xVelocity = 0;

    public ControlBrick(int x, int y, int width, int height, int score) {
        this.bounds = new Rectangle(x, y, width, height);
        this.score = score;
    }

    @Override
    public boolean isDestroyed() {
        return destroyed;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public void hit() {
        destroyed = true;
    }

    @Override
    public void setPosition(int x, int y) {
        bounds.setLocation(x, y);
    }

    @Override
    public Rectangle getBounds() {
        return bounds;
    }

    @Override
    public void move(int x, int y) {
        bounds.translate(xVelocity, y);

        if (xVelocity < 0 && bounds.x <= 0) {
            xVelocity = 0;
        } else if (xVelocity > 0 && bounds.x + bounds.width >= BrickBreakerGame.WIDTH) {
            xVelocity = 0;
        } else {
            xVelocity += x;
        }
    }

    // method to handle user input for moving the brick
    public void handleInput(int input) {
        switch (input) {
            case KeyEvent.VK_LEFT:
                xVelocity = -5;
                break;
            case KeyEvent.VK_RIGHT:
                xVelocity = 5;
                break;
            default:
                xVelocity = 0;
                break;
        }
    }
}

class Ball {
    private final int RADIUS = 10;
    private final int SPEED = 5;

    private int x;
    private int y;
    private int xVelocity;
    private int yVelocity;
    private final Rectangle bounds;

    public Ball(int x, int y, int xVelocity, int yVelocity) {
        this.x = x;
        this.y = y;
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
        this.bounds = new Rectangle(x - RADIUS, y - RADIUS, RADIUS * 2, RADIUS * 2);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRadius() {
        return RADIUS;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void move() {
        x += xVelocity * SPEED;
        y += yVelocity * SPEED;
        bounds.setLocation(x - RADIUS, y - RADIUS);
    }

    public void handleCollisions(Rectangle paddleBounds, Brick[] bricks) {
        handleWallCollision();
        handlePaddleCollision(paddleBounds);
        handleBrickCollision(bricks);
    }

    public void handleWallCollision() {
        if (x - RADIUS <= 0 || x + RADIUS >= BrickBreakerGame.WIDTH) {
            xVelocity = -xVelocity;
        }
        if (y - RADIUS <= 0) {
            yVelocity = -yVelocity;
        }
    }

    private void handlePaddleCollision(Rectangle paddleBounds) {
        if (bounds.intersects(paddleBounds)) {
            double relativeIntersectX = (paddleBounds.getX() + paddleBounds.getWidth() / 2) - x;
            double normalizedIntersectX = relativeIntersectX / (paddleBounds.getWidth() / 2);
            double bounceAngle = normalizedIntersectX * Math.PI / 3;
            xVelocity = (int) (SPEED * Math.sin(bounceAngle));
            yVelocity = -Math.abs((int) (SPEED * Math.cos(bounceAngle)));
        }
    }

    private void handleBrickCollision(Brick[] bricks) {
        for (Brick brick : bricks) {
            if (bounds.intersects(brick.getBounds()) && !brick.isDestroyed()) {
                brick.hit();
                Rectangle intersection = bounds.intersection(brick.getBounds());
                if (intersection.getWidth() > intersection.getHeight()) {
                    yVelocity = -yVelocity;
                } else {
                    xVelocity = -xVelocity;
                }
                break;
            }
        }
    }
}

class GameScreen {
    private static final int WALL_THICKNESS = 10;
    private static final int PADDLE_HEIGHT = 20;
    private static final int PADDLE_WIDTH = 100;
    private static final int BALL_RADIUS = 10;
    private static final int BRICK_WIDTH = 50;
    private static final int BRICK_HEIGHT = 25;
    private static final int BRICK_MARGIN = 10;

    private final int width;
    private final int height;
    private final Rectangle leftWall;
    private final Rectangle rightWall;
    private final Rectangle topWall;
    private final Rectangle paddle;
    private final Ball ball;
    private final ArrayList<Brick> bricks;
    private int score;
    private int numBounces;
    private int numBricks;

    public GameScreen(int width, int height) {
        this.width = width;
        this.height = height;

        // create walls
        leftWall = new Rectangle(0, 0, WALL_THICKNESS, height);
        rightWall = new Rectangle(width - WALL_THICKNESS, 0, WALL_THICKNESS, height);
        topWall = new Rectangle(0, 0, width, WALL_THICKNESS);

        // create paddle
        paddle = new Rectangle((width - PADDLE_WIDTH) / 2, height - PADDLE_HEIGHT - WALL_THICKNESS,
                PADDLE_WIDTH, PADDLE_HEIGHT);

        // create ball
        ball = new Ball(width / 2, height / 2, 1, -1);

        // create bricks
        bricks = new ArrayList<>();
        numBricks = 0;
        for (int row = 0; row < 4; row++) {
            int y = WALL_THICKNESS + row * (BRICK_HEIGHT + BRICK_MARGIN);
            for (int col = 0; col < width / (BRICK_WIDTH + BRICK_MARGIN) - 1; col++) {
                int x = WALL_THICKNESS + col * (BRICK_WIDTH + BRICK_MARGIN);
                Brick brick = new SimpleBrick(x, y, BRICK_WIDTH, BRICK_HEIGHT, 10);
                bricks.add(brick);
                numBricks++;
            }
        }
    }

    public void update() {
        // move ball
        ball.move();

        // handle collisions
        ball.handleCollisions(paddle, bricks.toArray(new Brick[0]));
        handleWallCollisions();

        // check if all bricks are destroyed
        if (numBricks == 0) {
            System.out.println("You won!");
        }
    }

    private void handleWallCollisions() {
        if (ball.getBounds().intersects(leftWall)) {
            ball.handleWallCollision();
        }
        if (ball.getBounds().intersects(rightWall)) {
            ball.handleWallCollision();
        }
        if (ball.getBounds().intersects(topWall)) {
            ball.handleWallCollision();
            numBounces++;
        }
    }

    public void handleInput(int input) {
        if (input == KeyEvent.VK_LEFT) {
            paddle.translate(-10, 0);
        } else if (input == KeyEvent.VK_RIGHT) {
            paddle.translate(10, 0);
        }
    }

    public void draw(Graphics2D g2d) {
        // draw walls
        g2d.setColor(Color.GRAY);
        g2d.fill(leftWall);
        g2d.fill(rightWall);
        g2d.fill(topWall);

        // draw paddle
        g2d.setColor(Color.BLUE);
        g2d.fill(paddle);

        // draw ball
        g2d.setColor(Color.RED);
        g2d.fillOval(ball.getX() - BALL_RADIUS, ball.getY() - BALL_RADIUS, BALL_RADIUS * 2, BALL_RADIUS * 2);

        // draw bricks
        for (Brick brick : bricks) {
            if (!brick.isDestroyed()) {
                if (brick instanceof SimpleBrick) {
                    g2d.setColor(Color.GREEN);
                } else if (brick instanceof HardBrick) {
                    g2d.setColor(Color.YELLOW);
                } else if (brick instanceof UnbreakableBrick) {
                    g2d.setColor(Color.ORANGE);
                } else if (brick instanceof MovingBrick) {
                    g2d.setColor(Color.PINK);
                } else if (brick instanceof AcceleratingBrick) {
                    g2d.setColor(Color.MAGENTA);
                } else if (brick instanceof ControlBrick) {
                    g2d.setColor(Color.CYAN);
                }
                g2d.fill(brick.getBounds());
            }
        }

        // draw score, numBounces, and numBricks
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Arial", Font.BOLD, 16));
        g2d.drawString("Score: " + score, 10, height - 10);
        g2d.drawString("Num Bounces: " + numBounces, 10, height - 30);
        g2d.drawString("Num Bricks: " + numBricks, 10, height - 50);
    }
}

class BrickBreakerGame extends JFrame implements KeyListener {
    private GameScreen gameScreen;
    private boolean isRunning;
    private final int FPS = 60;
    private final int DELAY = 1000 / FPS;

    public BrickBreakerGame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 800);
        setTitle("Brick Breaker");
        setLocationRelativeTo(null);
        setResizable(false);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        setVisible(true);
    }

    public void start() {
        // show game mode options
        Object[] options = {"Custom", "Random"};
        int choice = JOptionPane.showOptionDialog(this, "Choose a game mode:", "Game Mode",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        // create game screen with chosen game mode
        if (choice == JOptionPane.YES_OPTION) {
            gameScreen = new GameScreen(getWidth(), getHeight());
        } else {
            gameScreen = new GameScreen(getWidth(), getHeight(), true);
        }

        isRunning = true;
        gameLoop();
    }

    private void gameLoop() {
        long startTime;
        long endTime;
        long sleepTime;
        while (isRunning) {
            startTime = System.currentTimeMillis();

            updateGame();

            endTime = System.currentTimeMillis();
            sleepTime = DELAY - (endTime - startTime);

            if (sleepTime > 0) {
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void updateGame() {
        gameScreen.update();
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        gameScreen.draw(g2d);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        gameScreen.handleInput(e.getKeyCode());
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        gameScreen.handleInput(KeyEvent.VK_SPACE); // pause game with spacebar
    }

    public static void main(String[] args) {
        BrickBreakerGame game = new BrickBreakerGame();
        game.start();
    }
}