package component.components;

import component.ComponentType;
import component.EssentialComponent;
import component.SupplementalComponent;

public abstract class EssentialComponents {

    public static EssentialComponent LathePattern2A() {
        return new EssentialComponent("Lathe Pattern 2A Drive", -14, 40, ComponentType.PLASMA_DRIVE);
    }

    public static EssentialComponent Strelov1() {
        return new EssentialComponent("Strelov 1 Warp Engine", -10, -10, ComponentType.WARP_ENGINE);
    }

    public static EssentialComponent SingleVoidShieldArray() {
        return (EssentialComponent) new EssentialComponent("Single Void Shield Array", -1, -5, ComponentType.VOID_SHIELD)
                .defineModifiers(stats -> stats.shields += 1)
                .defineNotes("Shields +1");
    }

    public static EssentialComponent GellerField() {
        return new EssentialComponent("Geller Field", 0, -1, ComponentType.GELLER_FIELD);
    }

    public static EssentialComponent CombatBridge() {
        return new EssentialComponent("Combat Bridge", -1, -1, ComponentType.BRIDGE);
    }

    public static EssentialComponent ShipMastersBridge() {
        return (EssentialComponent) new EssentialComponent("Ship Master's Bridge", -3, -4, ComponentType.BRIDGE)
                .defineNotes("Shipboard BS +10, Shipboard Navigation +5");
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
