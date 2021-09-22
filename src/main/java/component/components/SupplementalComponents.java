package component.components;

import component.SupplementalComponent;

public abstract class SupplementalComponents {

    public static SupplementalComponent ArmorPlating() {
        return (SupplementalComponent) new SupplementalComponent("Armor Plating", -1, 0)
                .defineModifiers(stats -> {
                    stats.armor += 1;
                    stats.maneuver -= 2;
                })
                .defineNotes("Armor +1, Maneuverability -2");
    }

    public static SupplementalComponent FlakTurrets() {
        return (SupplementalComponent) new SupplementalComponent("Flak Turrets", -1, -1)
                .defineModifiers(stats -> {
                    stats.turrets += 1;
                    stats.detection -= 10;
                })
                .defineNotes("Toggleable, Turret Rating +1, Detection -10");
    }

}
