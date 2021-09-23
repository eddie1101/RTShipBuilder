package component.components;

import component.Quality;
import component.SupplementalComponent;

public abstract class SupplementalComponents {

    public static SupplementalComponent ArmorPlating() {
        return (SupplementalComponent) new SupplementalComponent("Armor Plating", -1, 0)
                .defineModifiers(stats -> {
                    stats.armor += 1;
                    stats.maneuver -= 2;
                })
                .defineNotes("Armor +1, Maneuverability -2")
                .defineQuality(Quality.COMMON);
    }

    public static SupplementalComponent FlakTurrets(Quality quality) {
        return (SupplementalComponent) new SupplementalComponent("Flak Turrets", -1, -1)
                .defineModifiers(stats -> {
                    stats.turrets += 1;
                    stats.detection -= 10;
                })
                .defineNotes("Toggleable, Turret Rating +1, Detection -10")
                .defineQuality(quality)
                .defineGoodQualityModifier(stats -> stats.space++)
                .defineBestQualityModifier(stats -> {
                    stats.power++;
                    stats.turrets++;
                });
    }

    public static SupplementalComponent TowHooks(Quality quality) {
        return (SupplementalComponent) new SupplementalComponent("Tow Hooks", 0, 0)
                .defineNotes("Allows towing of other ships")
                .defineQuality(quality)
                .defineGoodQualityModifier(stats -> stats.space++)
                .defineBestQualityModifier(stats -> stats.power++);
    }

    public static SupplementalComponent Countermeasures(Quality quality) {
        return (SupplementalComponent) new SupplementalComponent("Countermeasures", -1, -1)
                .defineNotes("For 1d5 + 1 turns, Incoming BS -2, Incoming Torpedo BS -30")
                .defineQuality(quality)
                .defineGoodQualityModifier(stats -> stats.space++)
                .defineBestQualityModifier(stats -> stats.power++);
    }

}
