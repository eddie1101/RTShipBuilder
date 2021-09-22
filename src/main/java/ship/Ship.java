package ship;

import component.*;
import component.components.EssentialComponents;
import component.components.SupplementalComponents;
import component.components.WeaponSlot;
import ship.stats.ShipStats;
import ship.stats.ShipStatsModifier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Ship {

    protected String name;
    protected String shipClass;

    protected String history;
    protected String complication;

    protected HullType hull;

    protected ShipStats stats;
    protected List<ShipStatsModifier> modifiers;

    protected ShipComponents components;

    public Ship(String name, String shipClass, HullType hull, ShipStats stats){
        this.name = name;
        this.shipClass = shipClass;
        this.hull = hull;

        this.stats = new ShipStats(stats);
        this.modifiers = new ArrayList<>();
        this.components = new ShipComponents();
    }

    public Ship addModifier(ShipStatsModifier modifier) {
        this.modifiers.add(modifier);
        return this;
    }

    public Ship addComponent(Component component) {

        if(component.getType() == ComponentType.SUPPLEMENTAL) {
            components.addSupplemental((SupplementalComponent) component);
        } else if(component.getType() != ComponentType.WEAPON) {
            components.setEssential((EssentialComponent) component);
        } else if(component.getType() == ComponentType.WEAPON) {
            System.err.println("Type WEAPON should be added with method addWeapon()");
            return this;
        }

        return this;
    }

    public Ship addSupplementalComponents(Component component, int multiplicity) {

        if(component.getType() != ComponentType.SUPPLEMENTAL) {
            System.err.println("Provided type is " + component.getType().toString() + ", Only SUPPLEMENTAL components can have multiplicities");
            return this;
        }

        for(int i = 0; i < multiplicity; i++) {
            addComponent(component);
        }
        return this;
    }

    public Ship addWeapon(WeaponComponent weapon, WeaponSlot slot) {
        components.addWeaponToSlot(weapon, slot);
        return this;
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

    public EssentialComponent getEssentialComponent(ComponentType type) {
        if(type == ComponentType.WEAPON) {
            System.err.println("Provided type WEAPON is not essential, use designated method getWeapons()");
            return null;
        } else if(type == ComponentType.SUPPLEMENTAL) {
            System.err.println("Provided type SUPPLEMENTAL is not essential, use designated method getSupplementalComponents()");
            return null;
        }

        return components.getEssential(type);

    }

    public ArrayList<SupplementalComponent> getSupplementalComponents() {
        return components.getSupplementals();
    }

    public ArrayList<EssentialComponent> getEssentialComponents() {
        return components.getEssentials();
    }

    public ArrayList<WeaponComponent> getWeapons() {
        return components.getWeaponsAsList();
    }

    public ArrayList<WeaponComponent> getWeaponsInSlot(WeaponSlot slot) {
        return new ArrayList<>(components.getWeaponsInSlot(slot).values());
    }

    public WeaponComponent getWeaponInSlotAt(WeaponSlot slot, int ID) {
        return components.getWeaponsInSlot(slot).get(ID);
    }

    private ShipStats applyModifiers() {
        ShipStats retVal = new ShipStats(stats);

        for(ShipStatsModifier modifier: components.getAllModifiers()) {
            modifier.apply(retVal);
        }

        for(ShipStatsModifier modifier: modifiers) {
            modifier.apply(retVal);
        }

        return retVal;
    }

    @Override
    public String toString() {
        StringBuilder retVal = new StringBuilder("Ship (The '" + name + "') {\n" +
                "\tShip Class: " + shipClass + "\n" +
                "\tHull Type: " + hull + "\n" +
                getStats().toString() + "\n" +
                "Components: " + "\n" +
                "\tEssential:\n" +
                "\t\tPlasma Drive: " + getEssentialComponent(ComponentType.PLASMA_DRIVE).toString() + "\n" +
                "\t\tWarp Engine: " + getEssentialComponent(ComponentType.WARP_ENGINE).toString() + "\n" +
                "\t\tGeller Field: " + getEssentialComponent(ComponentType.GELLER_FIELD).toString() + "\n" +
                "\t\tVoid Shield: " + getEssentialComponent(ComponentType.VOID_SHIELD).toString() + "\n" +
                "\t\tBridge: " + getEssentialComponent(ComponentType.BRIDGE).toString() + "\n" +
                "\t\tLife Sustainer: " + getEssentialComponent(ComponentType.LIFE_SUSTAINER).toString() + "\n" +
                "\t\tCrew Quarters: " + getEssentialComponent(ComponentType.CREW_QUARTERS).toString() + "\n" +
                "\t\tAugur Arrays: " + getEssentialComponent(ComponentType.AUGUR_ARRAYS).toString() + "\n" +
                "\tSupplemental:\n");

        for(SupplementalComponent component: getSupplementalComponents()) {
            retVal.append("\t\t").append(component.toString()).append("\n");
        }

        retVal.append("\tWeapons:\n");

        WeaponSlot[] slots = {WeaponSlot.DORSAL, WeaponSlot.STARBOARD, WeaponSlot.PORT, WeaponSlot.PROW, WeaponSlot.KEEL};

        for(WeaponSlot slot: slots) {
            retVal.append("\t\t").append(slot.toString()).append(":\n");
            for(WeaponComponent component: getWeaponsInSlot(slot)) {
                retVal.append("\t\t\t").append(component.toString()).append("\n");
            }
        }


        retVal.append("}");
        return retVal.toString();
    }

}
