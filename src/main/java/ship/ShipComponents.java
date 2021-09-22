package ship;

import component.*;
import component.components.EssentialComponents;
import component.components.WeaponSlot;
import ship.stats.ShipStatsModifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ShipComponents {

    private HashMap<ComponentType, EssentialComponent> eComponents;
    private HashMap<WeaponSlot, HashMap<Integer, WeaponComponent>> wComponents;
    private HashMap<WeaponSlot, Integer> numWeapons;
    private ArrayList<SupplementalComponent> sComponents;


    public ShipComponents() {
        initEssentials();
        initWeapons();
        sComponents = new ArrayList<>();
    }

    private void initEssentials() {
        eComponents = new HashMap<>();
        eComponents.put(ComponentType.PLASMA_DRIVE, null);
        eComponents.put(ComponentType.WARP_ENGINE, null);
        eComponents.put(ComponentType.GELLER_FIELD, null);
        eComponents.put(ComponentType.VOID_SHIELD, null);
        eComponents.put(ComponentType.BRIDGE, null);
        eComponents.put(ComponentType.LIFE_SUSTAINER, null);
        eComponents.put(ComponentType.CREW_QUARTERS, null);
        eComponents.put(ComponentType.AUGUR_ARRAYS, null);
    }

    private void initWeapons() {
        wComponents = new HashMap<>();
        wComponents.put(WeaponSlot.DORSAL, new HashMap<>());
        wComponents.put(WeaponSlot.PROW, new HashMap<>());
        wComponents.put(WeaponSlot.KEEL, new HashMap<>());
        wComponents.put(WeaponSlot.PORT, new HashMap<>());
        wComponents.put(WeaponSlot.STARBOARD, new HashMap<>());

        numWeapons = new HashMap<>();
        numWeapons.put(WeaponSlot.DORSAL, 0);
        numWeapons.put(WeaponSlot.PROW, 0);
        numWeapons.put(WeaponSlot.KEEL, 0);
        numWeapons.put(WeaponSlot.PORT, 0);
        numWeapons.put(WeaponSlot.STARBOARD, 0);
    }

    public ArrayList<SupplementalComponent> getSupplementals() {
        return sComponents;
    }

    public HashMap<Integer, WeaponComponent> getWeaponsInSlot(WeaponSlot slot) {
        return wComponents.get(slot);
    }

    public ArrayList<WeaponComponent> getWeaponsAsList() {
        ArrayList<WeaponComponent> weapons = new ArrayList<>();
        for(HashMap<Integer, WeaponComponent> map: wComponents.values()) {
            weapons.addAll(map.values());
        }
        return weapons;
    }

    public EssentialComponent getEssential(ComponentType type) {
        return eComponents.get(type);
    }

    public ArrayList<EssentialComponent> getEssentials() {
        return new ArrayList<>(eComponents.values());
    }

    public void addSupplemental(SupplementalComponent component) {
        sComponents.add(component);
    }

    public void setWeaponAtSlotID(WeaponComponent weapon, WeaponSlot slot, int ID) {
        if(wComponents.get(slot).get(ID) == null) {
            System.err.println("Weapon Slot ID " + ID + " doesn't exist! Determining ID automatically.");
            ID = numWeapons.get(slot);
            numWeapons.put(slot, ID + 1);
        }
        wComponents.get(slot).put(ID, weapon);
    }

    public void addWeaponToSlot(WeaponComponent weapon, WeaponSlot slot) {
        int ID = numWeapons.get(slot);
        numWeapons.put(slot, ID + 1);
        wComponents.get(slot).put(ID, weapon);
    }

    public void setEssential(EssentialComponent component) {
        eComponents.put(component.getType(), component);
    }

    public ArrayList<ShipStatsModifier> getAllModifiers() {
        ArrayList<Component> components = new ArrayList<>();
        components.addAll(getWeaponsAsList());
        components.addAll(sComponents);
        components.addAll(getEssentials());

        ArrayList<ShipStatsModifier> modifiers = new ArrayList<>();
        for(Component component: components) {
            modifiers.addAll(component.getModifiers());
        }
        return modifiers;
    }
}
