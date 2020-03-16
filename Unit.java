import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Unit {

    private int strong;
    private int firstHealth;
    private int health;
    private int speed;
    private int x;
    private int y;
    private int nr;
    private boolean isAlive = true;

    public Unit() {
        Random los = new Random();
        this.strong = los.nextInt(5) + 1;
        this.firstHealth = los.nextInt(5) + 1;
        this.health = this.firstHealth;
        this.speed = los.nextInt(5) + 1;
        this.x = los.nextInt(5) + 1;
        this.y = los.nextInt(5) + 1;
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
                    if (this.y >= mapWidth) {
                        this.y = this.y - 1;
                    } else {
                        this.y = this.y + 1;
                    }

                    break;
                case 2:
                    if (this.x >= mapLength) {
                        this.x = this.x - 1;
                    } else {
                        this.x = this.x + 1;
                    }
                    break;
                case 3:
                    if (this.y <= 1) {
                        this.y = this.y + 1;
                    } else {
                        this.y = this.y - 1;
                    }
                    break;
                case 4:
                    if (this.x <= 1) {
                        this.x = this.x + 1;
                    }
                    this.x = this.x - 1;
                    break;
            }
        }
    }

    public void Attack (List<Unit> unitList) {
        for (int i = 0; i<unitList.size (); i++) {
            if (this.x == unitList.get(i).x && this.y == unitList.get(i).y && this.nr != unitList.get(i).nr) {
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
