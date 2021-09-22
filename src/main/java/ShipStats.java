public class ShipStats {

    private static final ShipStats DEFAULT = new ShipStats(
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    );

    private int hullIntegrity;
    private int speed;
    private int armor;
    private int shields;
    private int maneuver;
    private int detection;

    private int crewCompetency;
    private int crewReq;

    private int space;
    private int power;
    private int turrets;

    private int shipPoints;

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

    public ShipStats(ShipStats stats) {
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

    public int getHullIntegrity() {
        return hullIntegrity;
    }

    public int getSpeed() {
        return speed;
    }

    public int getArmor() {
        return armor;
    }

    public int getShields() {
        return shields;
    }

    public int getManeuver() {
        return maneuver;
    }

    public int getDetection() {
        return detection;
    }

    public int getCrewCompetency() {
        return crewCompetency;
    }

    public int getCrewReq() {
        return crewReq;
    }

    public int getSpace() {
        return space;
    }

    public int getPower() {
        return power;
    }

    public int getTurrets() {
        return turrets;
    }

    public int getShipPoints() {
        return shipPoints;
    }

    public void setHullIntegrity(int hullIntegrity) {
        this.hullIntegrity = hullIntegrity;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public void setShields(int shields) {
        this.shields = shields;
    }

    public void setManeuver(int maneuver) {
        this.maneuver = maneuver;
    }

    public void setDetection(int detection) {
        this.detection = detection;
    }

    public void setCrewCompetency(int crewCompetency) {
        this.crewCompetency = crewCompetency;
    }

    public void setCrewReq(int crewReq) {
        this.crewReq = crewReq;
    }

    public void setSpace(int space) {
        this.space = space;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setTurrets(int turrets) {
        this.turrets = turrets;
    }

    public void setShipPoints(int shipPoints) {
        this.shipPoints = shipPoints;
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
                "\tSP: " + shipPoints + '\n';
    }


}
