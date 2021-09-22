import component.components.EssentialComponents;
import component.components.SupplementalComponents;
import component.components.WeaponComponents;
import component.components.WeaponSlot;
import ship.HullType;
import ship.Ship;
import ship.stats.ShipStats;

public class Main {

    static ShipStats jerichoStats = new ShipStats(50, 3, 12, 0, -10, 5, 0, 20000, 45, 0, 1, 20);

    public static void main(String[] args) {
        Ship jericho = new Ship("Crypt", "Jericho", HullType.TRANSPORT, jerichoStats)
                .addComponent(EssentialComponents.LathePattern2A())
                .addComponent(EssentialComponents.Strelov1())
                .addComponent(EssentialComponents.GellerField())
                .addComponent(EssentialComponents.SingleVoidShieldArray())
                .addComponent(EssentialComponents.ShipMastersBridge())
                .addComponent(EssentialComponents.VitaePatternLifeSustainer())
                .addComponent(EssentialComponents.VoidsmenQuarters())
                .addComponent(EssentialComponents.m201b())
                .addSupplementalComponents(SupplementalComponents.ArmorPlating(), 4)
                .addComponent(SupplementalComponents.FlakTurrets())
                .addWeapon(WeaponComponents.MarsPatternMacrocannons(), WeaponSlot.PROW)
                .addWeapon(WeaponComponents.MarsPatternMacrocannons(), WeaponSlot.PORT)
                .addWeapon(WeaponComponents.MarsPatternMacrocannons(), WeaponSlot.STARBOARD);

        System.out.println(jericho);
    }
}
