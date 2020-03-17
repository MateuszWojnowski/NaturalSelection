import java.util.List;
import java.util.ArrayList;


public class Simulation {
    private int mapWidth;
    private int mapLength;
    private int numberUnits;

    public Simulation (int mapWidth, int mapLength, int numberUnits) {
        this.mapWidth = mapWidth;
        this.mapLength = mapLength;
        this. numberUnits = numberUnits;
    }

    public List createAllUnits() {
        List<Unit> unitList = new ArrayList<>(this.numberUnits);
        for (int i = 0; i < this.numberUnits; i++) {
            unitList.add(new Unit());
            unitList.get(i).setNr(i);
        }
        System.out.println("Utworzono " + unitList.size() + " jednostek.\n");
        System.out.println("Oto parametry: ");
        for (Unit unit : unitList) {
            System.out.println("Jednostka nr. " + unit.getNr() + "   sila: " + unit.getStrong() + ", zdrowie: " + unit.getHealth() + ", szybkosc: " + unit.getSpeed ());
        }
        System.out.println();
        return unitList;
    }

    public List moveAll (List <Unit> unitList) {
        for (Unit unit : unitList) {
            unit.move(this.mapWidth, this.mapLength);
            unit.Attack(unitList);
        }

        List <Unit> livingUnits = new ArrayList<>();
        for (Unit unit : unitList) {
            if (unit.isAlive() == true) {
                livingUnits.add(unit);
            }
        }
        System.out.println("Pozostało jednostek: "+livingUnits.size());
        return livingUnits;
    }

    public void autostartMoveAll (List <Unit> unitList) {
        List<Unit> livingUnits = new Simulation (this.mapWidth, this.mapLength, this.numberUnits).moveAll(unitList);
        while (livingUnits.size() > 1) {
            livingUnits = new Simulation(this.mapWidth, this.mapLength, this.numberUnits).moveAll(unitList);
        }
        System.out.println("zostala jednostka nr "+livingUnits.get(0).getNr()+", o parametrach: " +
                "sila-"+ livingUnits.get(0).getStrong()+", poczatkowe zdrowie-"+
                livingUnits.get(0).getFirstHealth()+", predkosc-"+livingUnits.get(0).getSpeed());
    }
}