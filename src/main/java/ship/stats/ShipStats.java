package ship.stats;

public class ShipStats {

    private static final ShipStats DEFAULT = new ShipStats(
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    );

    public int hullIntegrity;
    public int speed;
    public int armor;
    public int shields;
    public int maneuver;
    public int detection;

    public int crewCompetency;
    public int crewReq;

    public int space;
    public int power;
    public int turrets;

    public int shipPoints;

    public ShipStats() {
        this(DEFAULT);
    }

    public ShipStats(int hullIntegrity, int speed, int armor, int shields, int maneuver, int detection, int crewCompetency, int crewReq, int space, int power, int turrets, int shipPoints) {
        this.hullIntegrity = hullIntegrity;
        this.speed = speed;
        this.armor = armor;
        this.shields = shields;
        this.maneuver = maneuver;
        this.detection = detection;
        this.crewCompetency = crewCompetency;
        this.crewReq = crewReq;
        this.space = space;
        this.power = power;
        this.turrets = turrets;
        this.shipPoints = shipPoints;
    }

    public ShipStats(final ShipStats stats) {
                this.hullIntegrity = stats.hullIntegrity;
                this.speed = stats.speed;
                this.armor = stats.armor;
                this.shields = stats.shields;
                this.maneuver = stats.maneuver;
                this.detection = stats.detection;
                this.crewCompetency = stats.crewCompetency;
                this.crewReq = stats.crewReq;
                this.space = stats.space;
                this.power = stats.power;
                this.turrets = stats.turrets;
                this.shipPoints = stats.shipPoints;
    }

    @Override
    public String toString() {
        return "Stats:\n" +
                "\tHull: " + hullIntegrity + '\n' +
                "\tSpeed: " + speed + '\n' +
                "\tArmor: " + armor + '\n' +
                "\tShields: " + shields + '\n' +
                "\tManeuver: " + maneuver + '\n' +
                "\tDetection: " + detection + '\n' +
                "\tCrew Competency: " + crewCompetency + '\n' +
                "\tCrew Requirement: " + crewReq + '\n' +
                "\tSpace: " + space + '\n' +
                "\tPower: " + power + '\n' +
                "\tTurrets: " + turrets + '\n' +
                "\tSP: " + shipPoints;
    }


}
