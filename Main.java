import java.util.List;

public class Main {

    public static void main (String args []) {

        Create units = new Create(5);
        List<Unit> unitList = units.createAllUnits();
        Simulation sim = new Simulation();
        sim.autostartMoveAll(unitList);
        }
    }

