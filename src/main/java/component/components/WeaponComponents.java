package component.components;

import component.Quality;
import component.WeaponComponent;

public abstract class WeaponComponents {

    public static WeaponComponent MarsPatternMacrocannons(Quality quality) {
        return (WeaponComponent) new WeaponComponent("Mars Pattern Macrobattery", -2, -4, 3, 2, 5, 6)
                .defineQuality(quality)
                .defineGoodQualityModifier(stats -> stats.space++)
                .defineBestQualityModifier(stats -> stats.power++);
    }

}
