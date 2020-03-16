import java.util.List;

public class Main {

    public static void main (String args []) {

        Simulation newSim = new Simulation (6,6,5);
        List<Unit> unitList = newSim.createAllUnits();
        newSim.autostartMoveAll(unitList);
        }
    }

