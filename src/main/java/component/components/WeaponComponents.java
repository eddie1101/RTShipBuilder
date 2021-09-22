package component.components;

import component.WeaponComponent;

public abstract class WeaponComponents {

    public static WeaponComponent MarsPatternMacrocannons() {
        return new WeaponComponent("Mars Pattern Macrobattery", -2, -4, 3, 2, 5, 6);
    }

}
