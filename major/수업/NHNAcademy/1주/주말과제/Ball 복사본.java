import java.awt.*;

public class Ball extends Rectangle {
    private Point velocity;
    private int angle;
    private int speed;

    public Ball(Point position, Dimension size, int angle, int speed) {
        super(position, size);
        this.velocity = new Point((int) (Math.cos(Math.toRadians(angle)) * speed),
                (int) (-Math.sin(Math.toRadians(angle)) * speed));
        this.angle = angle;
        this.speed = speed;
    }

    /**
     * 공을 이동시키는 메소드
     */
    public void move() {
        setLocation((int) (getX() + velocity.x), (int) (getY() + velocity.y));
    }

    /**
     * 공의 방향을 바꾸는 메소드
     *
     * @param axis 충돌한 축(0: x축, 1: y축)
     */
    public void reflect(int axis) {
        velocity.setLocation(velocity.x * (axis == 0 ? -1 : 1), velocity.y * (axis == 1 ? -1 : 1));
    }

    /**
     * 공의 각도를 변경하는 메소드
     *
     * @param x 벽돌 또는 벽과 충돌한 지점의 x 좌표
     */
    public void changeAngle(int x) {
        int center = (int) (getX() + getWidth() / 2);
        double ratio = (double) Math.abs(center - x) / (getWidth() / 2);
        if (ratio <= 0.4) {
            // 중앙에서 40% 이내의 영역
            angle = (int) Math.toDegrees(Math.atan2(-velocity.y, velocity.x));
        } else {
            // 바깥쪽 영역
            int sign = (center < x) ? -1 : 1;
            angle = (int) Math.toDegrees(Math.atan2(-velocity.y, velocity.x + sign * speed * 0.2));
        }
        velocity.setLocation((int) (Math.cos(Math.toRadians(angle)) * speed),
                (int) (-Math.sin(Math.toRadians(angle)) * speed));
    }
}
