package component.components;

import component.ComponentType;
import component.EssentialComponent;
import component.Quality;
import component.SupplementalComponent;

public abstract class EssentialComponents {

    public static EssentialComponent LathePattern2A() {
        return (EssentialComponent) new EssentialComponent("Lathe Pattern 2A Drive", -14, 40, ComponentType.PLASMA_DRIVE)
                .defineQuality(Quality.COMMON);
    }

    public static EssentialComponent Strelov1() {
        return (EssentialComponent) new EssentialComponent("Strelov 1 Warp Engine", -10, -10, ComponentType.WARP_ENGINE)
                .defineQuality(Quality.COMMON);
    }

    public static EssentialComponent SingleVoidShieldArray() {
        return (EssentialComponent) new EssentialComponent("Single Void Shield Array", -1, -5, ComponentType.VOID_SHIELD)
                .defineModifiers(stats -> stats.shields++)
                .defineNotes("Shields +2")
                .defineQuality(Quality.BEST)
                .defineGoodQualityModifier(stats -> stats.space++)
                .defineBestQualityModifier(stats -> {
                    stats.power++;
                    stats.shields++;
                });
    }

    public static EssentialComponent DualVoidShieldArray(Quality quality) {
        return (EssentialComponent) new EssentialComponent("Dual Void Shield Array", -2, -7, ComponentType.VOID_SHIELD)
                .defineModifiers(stats -> stats.shields += 2)
                .defineNotes("Shields +4")
                .defineQuality(quality)
                .defineGoodQualityModifier(stats -> {
                    stats.space++;
                    stats.shields++;
                })
                .defineBestQualityModifier(stats -> {
                    stats.power++;
                    stats.shields++;
                });
    }

    public static EssentialComponent GellerField() {
        return (EssentialComponent) new EssentialComponent("Geller Field", 0, -1, ComponentType.GELLER_FIELD)
                .defineQuality(Quality.COMMON);
    }

    public static EssentialComponent CombatBridge() {
        return (EssentialComponent) new EssentialComponent("Combat Bridge", -1, -1, ComponentType.BRIDGE)
                .defineQuality(Quality.COMMON);
    }

    public static EssentialComponent ShipMastersBridge() {
        return (EssentialComponent) new EssentialComponent("Ship Master's Bridge", -3, -4, ComponentType.BRIDGE)
                .defineNotes("Shipboard BS +10, Shipboard Navigation +5")
                .defineQuality(Quality.COMMON);
    }

    public static EssentialComponent VitaePatternLifeSustainer() {
        return new EssentialComponent("Vitae Pattern Life Sustainer", -2, -4, ComponentType.LIFE_SUSTAINER);
    }

    public static EssentialComponent VoidsmenQuarters() {
        return new EssentialComponent("Voidsmen Quarters", -3, -1, ComponentType.CREW_QUARTERS);
    }

    public static EssentialComponent m201b() {
        return (EssentialComponent) new EssentialComponent("m201b Augur Array", 0, -3, ComponentType.AUGUR_ARRAYS)
                .defineModifiers(stats -> stats.detection += 5)
                .defineNotes("Detection +5");
    }

    public static EssentialComponent VoidEye() {
        return (EssentialComponent) new EssentialComponent("Void Eye Augur Array", 0, -7, ComponentType.AUGUR_ARRAYS)
                .defineModifiers(stats -> stats.detection += 10)
                .defineNotes("Detection +10");
    }

}
