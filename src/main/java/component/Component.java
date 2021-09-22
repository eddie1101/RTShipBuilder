package component;

import ship.stats.ShipStatsModifier;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Component {

    protected int power;
    protected int space;

    protected String name;
    protected ComponentType type;
    protected Quality quality;
    protected float qualityCostMult = 1;

    protected ArrayList<ShipStatsModifier> modifiers;

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

    public Component defineNotes(String notes) {
        this.notes = notes;
        return this;
    }

    public String getNotes() {
        return this.notes;
    }

    public ComponentType getType() {
        return this.type;
    }

    public ArrayList<ShipStatsModifier> getModifiers() {
        return this.modifiers;
    }

    @Override
    public String toString() {
        return this.name + ":" + this.space + "|" + this.power + "\t" + this.notes;
    }

}
