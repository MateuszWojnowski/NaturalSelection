import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Unit {

    private int strong;
    private int firstHealth;
    private int health;
    private int speed;
    private int nr;
    private boolean isAlive;
    Position position;

    public Unit() {
        Random los = new Random();
        this.strong = los.nextInt(5) + 1;
        this.firstHealth = los.nextInt(5) + 1;
        this.health = this.firstHealth;
        this.speed = los.nextInt(5) + 1;
        this.isAlive = true;
        this.position = new Position();
    }

    public int getStrong () {
        return this.strong;
    }

    public int getHealth () {
        return this.health;
    }

    public int getFirstHealth () {
        return this.firstHealth;
    }

    public int getSpeed () {
        return this.speed;
    }

    public void setNr (int nr) {
        this.nr = nr;
    }

    public int getNr () {
        return this.nr;
    }

    public boolean isAlive () {
        return (this.health > 0);
    }

    public void move (int mapWidth, int mapLength) {
        Random los = new Random ();
        int losDistance = los.nextInt(5)+1;
        for (int distance = losDistance; distance>0; distance--) {
            switch (los.nextInt(4) + 1) {
                case 1:
                    if (this.position.getY() >= mapWidth) {
                        this.position.setY(this.position.getY() - 1);
                    } else {
                        this.position.setY(this.position.getY() + 1);
                    }

                    break;
                case 2:
                    if (this.position.getX() >= mapLength) {
                        this.position.setX(this.position.getX() - 1);
                    } else {
                        this.position.setX(this.position.getX() + 1);
                    }
                    break;
                case 3:
                    if (this.position.getY() <= 1) {
                        this.position.setY(this.position.getY() + 1);
                    } else {
                        this.position.setY(this.position.getY() - 1);
                    }
                    break;
                case 4:
                    if (this.position.getX() <= 1) {
                        this.position.setX(this.position.getX() + 1);
                    }
                    this.position.setX(this.position.getX() - 1);
                    break;
            }
        }
    }

    public void Attack (List<Unit> unitList) {
        for (int i = 0; i<unitList.size (); i++) {
            if (this.position.getX() == unitList.get(i).position.getX() && this.position.getY() == unitList.get(i).position.getY() && this.nr != unitList.get(i).nr) {
                    if (this.speed > unitList.get(i).speed) {
                        unitList.get(i).health = unitList.get(i).health - this.strong;
                        System.out.println("jednostka nr "+this.nr+" zaatakowala jednostke nr "+unitList.get(i).nr);
                    } else {
                        this.health = this.health - unitList.get(i).strong;
                        System.out.println("jednostka nr "+unitList.get(i).nr+" zaatakowala jednostke nr "+this.nr);
                    }

            }
        }
    }
}
