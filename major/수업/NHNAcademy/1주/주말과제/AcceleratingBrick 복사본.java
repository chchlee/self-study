import java.awt.*;

public class AcceleratingBrick implements Brick {
    private Point position;
    private Dimension size;
    private int speed;

    public AcceleratingBrick(Point position, Dimension size, int speed) {
        this.position = position;
        this.size = size;
        this.speed = speed;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.YELLOW);
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
     * 벽돌의 속도를 증가시키는 메소드
     * @param acceleration 속도 증가량
     */
    public void accelerate(int acceleration) {
        speed += acceleration;
    }

    /**
     * 벽돌을 이동시키는 메소드
     */
    public void move() {
        position.y += speed;
    }
}
