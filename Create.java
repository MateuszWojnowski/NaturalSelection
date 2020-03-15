import java.util.ArrayList;
import java.util.List;

public class Create {
    private int numberUnits;

    public Create (int numberUnits) {
        this.numberUnits = numberUnits;
    }

    public List createAllUnits() {
        List<Unit> unitList = new ArrayList<>(this.numberUnits);
        for (int i = 0; i < this.numberUnits; i++) {
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
