import java.awt.*;

public interface Brick {
    /**
     * 벽돌을 그리는 메소드
     */
    void draw(Graphics g);

    /**
     * 벽돌의 현재 위치를 반환하는 메소드
     * @return 벽돌의 위치
     */
    Point getPosition();

    /**
     * 벽돌의 크기를 반환하는 메소드
     * @return 벽돌의 크기
     */
    Dimension getSize();

    /**
     * 벽돌이 부딪혔을 때의 처리를 하는 메소드
     * @return 벽돌이 깨졌는지 여부
     */
    boolean handleCollision();
}
