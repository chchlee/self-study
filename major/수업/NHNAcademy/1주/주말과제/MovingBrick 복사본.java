import java.awt.*;

public class MovingBrick implements Brick {
    private Point position;
    private Dimension size;
    private int speed;
    private int direction;

    public MovingBrick(Point position, Dimension size, int speed, int direction) {
        this.position = position;
        this.size = size;
        this.speed = speed;
        this.direction = direction;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillRect(position.x, position.y, size.width, size.height);
    }

    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public Dimension getSize() {
        return size;
    }

    @Override
    public boolean handleCollision() {
        return true;
    }

    /**
     * 벽돌을 이동시키는 메소드
     *
     * @param bounds 벽돌이 이동할 수 있는 범위
     */
    public void move(Rectangle bounds) {
        int x = position.x + speed * direction;
        if (x < bounds.x || x + size.width > bounds.x + bounds.width) {
            direction = -direction;
        } else {
            position.x = x;
        }
    }
}
