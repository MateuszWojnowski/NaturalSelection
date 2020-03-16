import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private int mapWidth; // szerokosc
    private int mapLength; //wysokosc
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
        for (int i = 0; i < unitList.size(); i++) {
            System.out.println("Jednostka nr. " + unitList.get(i).getNr() + "   sila: " + unitList.get(i).getStrong() + ", zdrowie: " + unitList.get(i).getHealth() + ", szybkosc: " + unitList.get(i).getSpeed ());
        }
        System.out.println();
        return unitList;
    }

    public static List moveAll (int mapWidth, int mapLength, List <Unit> unitList) {
        for (int i = 0; i<unitList.size(); i++) {
            unitList.get(i).move(mapWidth, mapLength);
            unitList.get(i).Attack(unitList);
        }

        List <Unit> livingUnits = new ArrayList<>();
        for (int i = 0; i<unitList.size(); i++) {
            if (unitList.get(i).isAlive() == true) {
                livingUnits.add(unitList.get(i));
            }
        }
        System.out.println("Pozostało jednostek: "+livingUnits.size());
        return livingUnits;
    }

    public void autostartMoveAll (List <Unit> unitList) {
        List<Unit> livingUnits = Simulation.moveAll(this.mapWidth, this.mapLength, unitList);
        while (livingUnits.size() > 1) {
            livingUnits = Simulation.moveAll(this.mapWidth, this.mapLength, unitList);
        }
        System.out.println("zostala jednostka nr "+livingUnits.get(0).getNr()+", o parametrach: " +
                "sila-"+ livingUnits.get(0).getStrong()+", poczatkowe zdrowie-"+
                livingUnits.get(0).getFirstHealth()+", predkosc-"+livingUnits.get(0).getSpeed());
    }
}
