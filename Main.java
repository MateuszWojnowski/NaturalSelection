import java.util.List;

public class Main {

    public static void main (String args []) {

        List<Unit> unitList = Unit.createAllUnits(7);
        MoveUnit.autostartMoveAll(unitList);
        }
    }
