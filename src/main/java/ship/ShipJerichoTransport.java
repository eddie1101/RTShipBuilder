package ship;

import ship.stats.ShipStats;

public class ShipJerichoTransport extends Ship {

    private static final String SHIP_CLASS = "Jericho";

    public ShipJerichoTransport(String name) {
        super(name, SHIP_CLASS, HullType.TRANSPORT, new ShipStats(
                50, 3, 12, 0, -10, 5, 0, 20000, 45, 0, 1, 20
        ));
    }

}
