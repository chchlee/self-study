import java.awt.*;

public class ControlledBrick implements Brick {
    private Point position;
    private Dimension size;
    private int speed;

    public ControlledBrick(Point position, Dimension size, int speed) {
        this.position = position;
        this.size = size;
        this.speed = speed;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.PINK);
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
     * @param direction 이동 방향(-1: 왼쪽, 1: 오른쪽)
     * @param bounds 벽돌이 이동할 수 있는 범위
     */
    public void move(int direction, Rectangle bounds) {
        int x = position.x + speed * direction;
        if (x < bounds.x) {
            x = bounds.x;
        } else if (x + size.width > bounds.x + bounds.width) {
            x = bounds.x + bounds.width - size.width;
        }
        position.x = x;
    }

}
