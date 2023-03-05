import java.awt.*;

public class SimpleBrick implements Brick {
    private Point position;
    private Dimension size;

    public SimpleBrick(Point position, Dimension size) {
        this.position = position;
        this.size = size;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.RED);
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
}
