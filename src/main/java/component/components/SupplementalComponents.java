package component.components;

import component.SupplementalComponent;

public abstract class SupplementalComponents {

    public static SupplementalComponent ArmorPlating() {
        return (SupplementalComponent) new SupplementalComponent("Armor Plating", -1, 0)
                .defineModifiers(stats -> {
                    stats.armor += 1;
                    stats.maneuver -= 2;
                });
    }

}
