package component;

public class WeaponComponent extends Component {

    protected int strength;
    protected int damage;
    protected int critical;
    protected int range;

    public WeaponComponent(String name, int space, int power, int strength, int damage, int critical, int range) {
        super(name, space, power, ComponentType.WEAPON);
        this.strength = strength;
        this.damage = damage;
        this.critical = critical;
        this.range = range;
    }

}
