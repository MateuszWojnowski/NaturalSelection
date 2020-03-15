import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Unit {

    int strong;
    int firstHealth;
    int health;
    int speed;
    int x;
    int y;
    int nr;
    boolean isAlive = true;

    public Unit() {
        Random los = new Random();
        this.strong = los.nextInt(5) + 1;
        this.firstHealth = los.nextInt(5) + 1;
        this.health = this.firstHealth;
        this.speed = los.nextInt(5) + 1;
        this.x = los.nextInt(5) + 1;
        this.y = los.nextInt(5) + 1;
        this.isAlive = true;
    }

    public void move () {
        Map map = new Map (6,6);
        Random los = new Random ();
        int losDistance = los.nextInt(5)+1;
        for (int distance = losDistance; distance>0; distance--) {
            switch (los.nextInt(4) + 1) {
                case 1:
                    if (this.y >= map.width) {
                        this.y = this.y - 1;
                    } else {
                        this.y = this.y + 1;
                    }

                    break;
                case 2:
                    if (this.x >= map.length) {
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

    void Attack (List<Unit> unitList) {
        for (int i = 0; i<unitList.size (); i++) {
            if (this.x == unitList.get(i).x && this.y == unitList.get(i).y) {
                if (this.nr != unitList.get(i).nr) {
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

}
