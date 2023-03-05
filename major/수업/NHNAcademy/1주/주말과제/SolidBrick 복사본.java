import java.awt.*;

public class SolidBrick implements Brick {
    private Point position;
    private Dimension size;

    public SolidBrick(Point position, Dimension size) {
        this.position = position;
        this.size = size;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
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
        return false;
    }
}
