interface Brick {
    public int getScore();
    public boolean isDestroyed();
    public void hit();
}

// 한번에 깨지는 벽돌 클래스
class SimpleBrick implements Brick {
    private int score;
    private boolean isDestroyed;

    public SimpleBrick(int score) {
        this.score = score;
        isDestroyed = false;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public boolean isDestroyed() {
        return isDestroyed;
    }

    @Override
    public void hit() {
        isDestroyed = true;
    }
}

// 2번 이상 맞으면 깨지는 벽돌 클래스
class HardBrick implements Brick {
    private int score;
    private boolean isDestroyed;
    private int hitCount;
    private int maxHitCount;

    public HardBrick(int score, int maxHitCount) {
        this.score = score;
        isDestroyed = false;
        hitCount = 0;
        this.maxHitCount = maxHitCount;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public boolean isDestroyed() {
        return isDestroyed;
    }

    @Override
    public void hit() {
        hitCount++;
        if (hitCount >= maxHitCount) {
            isDestroyed = true;
        }
    }
}

// 깨지지 않는 벽돌 클래스
class IndestructibleBrick implements Brick {
    private int score;
    public IndestructibleBrick(int score) {
        this.score = score;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public boolean isDestroyed() {
        return false;
    }

    @Override
    public void hit() {
        // Do nothing
    }
}

// 좌우로 움직이는 벽돌 인터페이스
interface MovingBrick extends Brick {
    public void move();
}

// 좌우로 움직이는 벽돌 클래스
class HorizontalMovingBrick extends IndestructibleBrick implements MovingBrick {
    private int x;
    private int speed;
    private int direction;
    private int maxX;

    public HorizontalMovingBrick(int score, int x, int speed, int maxX) {
        super(score);
        this.x = x;
        this.speed = speed;
        direction = 1;
        this.maxX = maxX;
    }

    @Override
    public void move() {
        x += direction * speed;
        if (x <= 0 || x >= maxX) {
            direction = -direction;
        }
    }
}

// 가속도 벽돌 클래스
class AccelerationBrick extends SimpleBrick {
    private int speedIncrement;

    public AccelerationBrick(int score, int speedIncrement) {
        super(score);
        this.speedIncrement = speedIncrement;
    }

    public int getSpeedIncrement() {
        return speedIncrement;
    }
}

// 제어 벽돌 인터페이스
interface ControlledBrick extends MovingBrick {
    public void moveLeft();
    public void moveRight();
}
class UserControlledBrick extends SimpleBrick implements ControlledBrick {
    private int x;
    private int speed;
    private int maxX;

    public UserControlledBrick(int score, int x, int speed, int maxX) {
        super(score);
        this.x = x;
        this.speed = speed;
        this.maxX = maxX;
    }

    @Override
    public void moveLeft() {
        x -= speed;
        if (x < 0) {
            x = 0;
        }
    }

    @Override
    public void moveRight() {
        x += speed;
        if (x > maxX) {
            x = maxX;
        }
    }

    @Override
    public void move() {
        // Do nothing
    }

    public int getX() {
        return x;
    }
}

class Ball {
    private int x;
    private int y;
    private int size;
    private int dx;
    private int dy;
    private int maxDx;
    private int maxDy;
    private int minDy;

    public Ball(int x, int y, int size, int dx, int dy, int maxDx, int maxDy, int minDy) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.dx = dx;
        this.dy = dy;
        this.maxDx = maxDx;
        this.maxDy = maxDy;
        this.minDy = minDy;
    }

    public void move() {
        x += dx;
        y += dy;
        if (dx > maxDx) {
            dx = maxDx;
        }
        if (dy > maxDy) {
            dy = maxDy;
        }
        if (dy < minDy) {
            dy = minDy;
        }
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSize() {
        return size;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }
}