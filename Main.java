import java.util.List;

public class Main {

    public static void main (String args []) {

        Simulation Simulation = new Simulation (6,6,5);
        List<Unit> unitList = Simulation.createAllUnits();
        Simulation.autostartMoveAll(unitList);
        }
    }