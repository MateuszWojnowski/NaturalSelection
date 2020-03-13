import java.util.List;

public class Attack {

    static void isAttack (Unit unit, List<Unit> unitList) {
        for (int i = 0; i<unitList.size (); i++) {
            if (unit.x == unitList.get(i).x && unit.y == unitList.get(i).y) {
                if (unit.nr != unitList.get(i).nr) {
                    if (unit.speed > unitList.get(i).speed) {
                        unitList.get(i).health = unitList.get(i).health - unit.strong;
                        System.out.println("jednostka nr "+unit.nr+" zaatakowala jednostke nr "+unitList.get(i).nr);
                    } else {
                        unit.health = unit.health - unitList.get(i).strong;
                        System.out.println("jednostka nr "+unitList.get(i).nr+" zaatakowala jednostke nr "+unit.nr);
                    }
                }
            }
        }
    }
}

