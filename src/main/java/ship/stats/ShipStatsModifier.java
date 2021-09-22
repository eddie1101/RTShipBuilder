package ship.stats;

@FunctionalInterface
public interface ShipStatsModifier {

    void apply(ShipStats stats);

}
