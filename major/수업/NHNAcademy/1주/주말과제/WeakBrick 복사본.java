import java.awt.*;

public class WeakBrick implements Brick {
    private Point position;
    private Dimension size;
    private int health;

    public WeakBrick(Point position, Dimension size, int health) {
        this.position = position;
        this.size = size;
        this.health = health;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
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
        health--;
        if (health <= 0) {
            return true;
        } else {
            return false;
        }
    }
}
