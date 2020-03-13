import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MoveUnit {

    static void move (Unit unit) {
        Random los = new Random ();
        int losDistance = los.nextInt(5)+1;
        for (int distance = losDistance; distance>0; distance--) {
            switch (los.nextInt(4) + 1) {
                case 1:
                    if (unit.y >= 6) {
                        unit.y = unit.y - 1;
                    } else {
                        unit.y = unit.y + 1;
                    }

                    break;
                case 2:
                    if (unit.x >= 6) {
                        unit.x = unit.x - 1;
                    } else {
                        unit.x = unit.x + 1;
                    }
                    break;
                case 3:
                    if (unit.y <= 1) {
                        unit.y = unit.y + 1;
                    } else {
                        unit.y = unit.y - 1;
                    }
                    break;
                case 4:
                    if (unit.x <= 1) {
                        unit.x = unit.x + 1;
                    }
                    unit.x = unit.x - 1;
                    break;
            }
        }
    }

    static List moveAll (List <Unit> unitList) {
        for (int i = 0; i<unitList.size(); i++) {
            MoveUnit.move(unitList.get(i));
            Attack.isAttack(unitList.get(i), unitList);
        }

        for  (int i = 0; i<unitList.size(); i++) {
            if (unitList.get(i).health < 1) {
                unitList.get(i).isAlive = false;
            }
        }
        List <Unit> livingUnits = new ArrayList<>();
        for (int i = 0; i<unitList.size(); i++) {
            if (unitList.get(i).isAlive == true) {
                livingUnits.add(unitList.get(i));
            }
        }
        System.out.println("Pozostało jednostek: "+livingUnits.size());
        return livingUnits;
    }

    static void autostartMoveAll (List <Unit> unitList) {
            List<Unit> livingUnits = MoveUnit.moveAll(unitList);
            while (livingUnits.size() > 1) {
                livingUnits = MoveUnit.moveAll(unitList);
            }
            System.out.println("zostala jednostka nr "+livingUnits.get(0).nr+", o parametrach: " +
                    "sila-"+ livingUnits.get(0).strong+", poczatkowe zdrowie-"+
                    livingUnits.get(0).health+", predkosc-"+livingUnits.get(0).speed);
    }
}
