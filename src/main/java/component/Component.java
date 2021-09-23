package component;

import ship.stats.ShipStatsModifier;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class Component {

    protected int power;
    protected int space;

    protected String name;
    protected ComponentType type;
    protected Quality quality;
    protected float qualityCostMult = 1;

    protected boolean enabled = true;

    protected ArrayList<ShipStatsModifier> modifiers;
    protected ShipStatsModifier goodQualityModifier;
    protected ShipStatsModifier bestQualityModifier;

    protected String notes;

    public Component(String name, int space, int power, ComponentType type) {
        this.name = name;
        this.space = space;
        this.power = power;
        this.type = type;
        this.quality = Quality.COMMON;
        this.notes = "";

        this.modifiers = new ArrayList<>();
        defineModifiers();
        defineGoodQualityModifier(stats -> {});
        defineBestQualityModifier(stats -> {});
    }

    public Component defineModifiers(ShipStatsModifier... modifiers) {
        this.modifiers.addAll(Arrays.asList(modifiers));
        return this;
    }

    private void defineModifiers() {
        this.modifiers.add(stats -> {
            stats.power += this.power;
            stats.space += this.space;
        });
    }

    public Component defineGoodQualityModifier(ShipStatsModifier modifier) {
        this.goodQualityModifier = modifier;
        return this;
    }

    public Component defineBestQualityModifier(ShipStatsModifier modifier) {
        this.bestQualityModifier = modifier;
        return this;
    }

    public Component defineQuality(Quality quality) {
        this.quality = quality;
        return this;
    }

    public Component defineNotes(String notes) {
        this.notes = notes;
        return this;
    }

    public void upgrade() {
        if(quality == Quality.POOR) {
            quality = Quality.COMMON;
        } else if(quality == Quality.COMMON) {
            quality = Quality.GOOD;
        } else if(quality == Quality.GOOD) {
            quality = Quality.BEST;
        }
    }

    public String getNotes() {
        return this.notes;
    }

    public ComponentType getType() {
        return this.type;
    }

    public ArrayList<ShipStatsModifier> getModifiers() {
        ArrayList<ShipStatsModifier> modifiers = new ArrayList<>();
        modifiers.addAll(this.modifiers);
        if(quality.ordinal() > Quality.COMMON.ordinal()) {
            modifiers.add(goodQualityModifier);
        }
        if(quality.ordinal() > Quality.GOOD.ordinal()) {
            modifiers.add(bestQualityModifier);
        }
        return modifiers;
    }

    public ArrayList<ShipStatsModifier> getRawModifiers() {
        return modifiers;
    }

    public ShipStatsModifier getGoodQualityModifier() {
        return goodQualityModifier;
    }

    public ShipStatsModifier getBestQualityModifier() {
        return bestQualityModifier;
    }

    public boolean enabled() {
        return enabled;
    }

    public void toggle() {
        enabled = !enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return String.format("%1$-35s|%2$-3d|%3$-3d|%4$-100s", this.name, this.space, this.power, this.notes);
    }

}
