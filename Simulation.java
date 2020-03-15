import java.util.ArrayList;
import java.util.List;

public class Simulation {

    static List moveAll (List <Unit> unitList) {
        for (int i = 0; i<unitList.size(); i++) {
            unitList.get(i).move();
            unitList.get(i).Attack(unitList);
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

    void autostartMoveAll (List <Unit> unitList) {
        List<Unit> livingUnits = Simulation.moveAll(unitList);
        while (livingUnits.size() > 1) {
            livingUnits = Simulation.moveAll(unitList);
        }
        System.out.println("zostala jednostka nr "+livingUnits.get(0).nr+", o parametrach: " +
                "sila-"+ livingUnits.get(0).strong+", poczatkowe zdrowie-"+
                livingUnits.get(0).firstHealth+", predkosc-"+livingUnits.get(0).speed);
    }
}
