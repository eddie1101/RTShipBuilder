import java.util.ArrayList;
import java.util.List;

public abstract class Ship {

    protected String name;
    protected String shipClass;

    protected HullType hull;

    protected ShipStats stats;
    protected List<ShipStatsModifier> modifiers;

    public Ship(String name, String shipClass, HullType hull, ShipStats stats){
        this.name = name;
        this.shipClass = shipClass;
        this.hull = hull;

        this.stats = new ShipStats(stats);
        this.modifiers = new ArrayList<>();
    }

    public void addModifier(ShipStatsModifier modifier) {
        this.modifiers.add(modifier);
    }

    public ShipStats getStatsRaw() {
        return stats;
    }

    public ShipStats getStats() {
        return applyModifiers();
    }

    public String getName() {
        return name;
    }

    private ShipStats applyModifiers() {
        ShipStats retVal = new ShipStats(stats);
        for(ShipStatsModifier modifier: modifiers) {
            modifier.apply(retVal);
        }
        return retVal;
    }

    @Override
    public String toString() {
        return "Ship (The '" + name + "') {\n" +
                "\tShip Class: " + shipClass + "\n" +
                "\tHull Type: " + hull + "\n" +
                getStats().toString() +
                "}";
    }

}
