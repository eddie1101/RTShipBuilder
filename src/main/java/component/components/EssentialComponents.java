package component.components;

import component.ComponentType;
import component.EssentialComponent;
import component.Quality;
import component.SupplementalComponent;

public abstract class EssentialComponents {

    public static EssentialComponent LathePattern2A(Quality quality) {
        return (EssentialComponent) new EssentialComponent("Lathe Pattern 2A Drive", -14, 40, ComponentType.PLASMA_DRIVE)
                .defineQuality(quality)
                .defineGoodQualityModifier(stats -> stats.space++)
                .defineBestQualityModifier(stats -> stats.power++);
    }

    public static EssentialComponent Strelov1(Quality quality) {
        return (EssentialComponent) new EssentialComponent("Strelov 1 Warp Engine", -10, -10, ComponentType.WARP_ENGINE)
                .defineQuality(quality)
                .defineGoodQualityModifier(stats -> stats.space++)
                .defineBestQualityModifier(stats -> stats.power++);
    }

    public static EssentialComponent SingleVoidShieldArray(Quality quality) {
        return (EssentialComponent) new EssentialComponent("Single Void Shield Array", -1, -5, ComponentType.VOID_SHIELD)
                .defineModifiers(stats -> stats.shields++)
                .defineQuality(quality)
                .defineGoodQualityModifier(stats -> stats.space++)
                .defineBestQualityModifier(stats -> {
                    stats.power++;
                    stats.shields++;
                });
    }

    public static EssentialComponent DualVoidShieldArray(Quality quality) {
        return (EssentialComponent) new EssentialComponent("Dual Void Shield Array", -2, -7, ComponentType.VOID_SHIELD)
                .defineModifiers(stats -> stats.shields += 2)
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

    public static EssentialComponent CombatBridge(Quality quality) {
        return (EssentialComponent) new EssentialComponent("Combat Bridge", -1, -1, ComponentType.BRIDGE)
                .defineQuality(quality)
                .defineGoodQualityModifier(stats -> stats.space++)
                .defineBestQualityModifier(stats -> stats.power++);
    }

    public static EssentialComponent ShipMastersBridge(Quality quality) {
        return (EssentialComponent) new EssentialComponent("Ship Master's Bridge", -3, -4, ComponentType.BRIDGE)
                .defineNotes("Shipboard BS +10, Shipboard Navigation +5")
                .defineQuality(quality)
                .defineGoodQualityModifier(stats -> stats.space++)
                .defineBestQualityModifier(stats -> stats.power++);
    }

    public static EssentialComponent VitaePatternLifeSustainer(Quality quality) {
        return (EssentialComponent) new EssentialComponent("Vitae Pattern Life Sustainer", -2, -4, ComponentType.LIFE_SUSTAINER)
                .defineQuality(quality)
                .defineGoodQualityModifier(stats -> stats.space++)
                .defineBestQualityModifier(stats -> stats.power++);
    }

    public static EssentialComponent VoidsmenQuarters(Quality quality) {
        return (EssentialComponent) new EssentialComponent("Voidsmen Quarters", -3, -1, ComponentType.CREW_QUARTERS)
                .defineQuality(quality)
                .defineGoodQualityModifier(stats -> stats.space++)
                .defineBestQualityModifier(stats -> stats.power++);
    }

    public static EssentialComponent m201b(Quality quality) {
        return (EssentialComponent) new EssentialComponent("m201b Augur Array", 0, -3, ComponentType.AUGUR_ARRAYS)
                .defineModifiers(stats -> stats.detection += 5)
                .defineNotes("Detection +5")
                .defineQuality(quality)
                .defineGoodQualityModifier(stats -> stats.space++)
                .defineBestQualityModifier(stats -> stats.power++);
    }

    public static EssentialComponent VoidEye(Quality quality) {
        return (EssentialComponent) new EssentialComponent("Void Eye Augur Array", 0, -7, ComponentType.AUGUR_ARRAYS)
                .defineModifiers(stats -> stats.detection += 10)
                .defineNotes("Detection +10")
                .defineQuality(quality)
                .defineGoodQualityModifier(stats -> stats.space++)
                .defineBestQualityModifier(stats -> stats.power++);
    }

}
