import java.util.Random;

public class Position {

    private int x;
    private int y;

    public Position () {
        Random los = new Random();
        this.x = los.nextInt(5) + 1;
        this.y = los.nextInt(5) + 1;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
