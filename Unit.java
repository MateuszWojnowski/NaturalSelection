import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Unit {

    int strong;
    int first_health;
    int health;
    int speed;
    int x;
    int y;
    int nr;
    boolean isAlive = true;

    public Unit() {
        Random los = new Random();
        this.strong = los.nextInt(5) + 1;
        this.first_health = los.nextInt(5) + 1;
        this.health = this.first_health;
        this.speed = los.nextInt(5) + 1;
        this.x = los.nextInt(5) + 1;
        this.y = los.nextInt(5) + 1;
        this.isAlive = true;
    }

    static List createAllUnits(int numberUnits) {
        List<Unit> unitList = new ArrayList<>(numberUnits);
        for (int i = 0; i < numberUnits; i++) {
            unitList.add(new Unit());
            unitList.get(i).nr = i;
        }
        System.out.println("Utworzono " + unitList.size() + " jednostek.\n");
        System.out.println("Oto parametry: ");
        for (int i = 0; i < unitList.size(); i++) {
            System.out.println("Jednostka nr. " + unitList.get(i).nr + "   sila: " + unitList.get(i).strong + ", zdrowie: " + unitList.get(i).health + ", szybkosc: " + unitList.get(i).speed);
        }
        System.out.println();
        return unitList;
    }
}
