import component.Quality;
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
                .addComponent(EssentialComponents.LathePattern2A(Quality.COMMON))
                .addComponent(EssentialComponents.Strelov1(Quality.COMMON))
                .addComponent(EssentialComponents.GellerField())
                .addComponent(EssentialComponents.SingleVoidShieldArray(Quality.BEST))
                .addComponent(EssentialComponents.ShipMastersBridge(Quality.COMMON))
                .addComponent(EssentialComponents.VitaePatternLifeSustainer(Quality.COMMON))
                .addComponent(EssentialComponents.VoidsmenQuarters(Quality.COMMON))
                .addComponent(EssentialComponents.m201b(Quality.COMMON))
                .addSupplementalComponents(SupplementalComponents.ArmorPlating(), 4)
                .addComponent(SupplementalComponents.FlakTurrets(Quality.BEST))
                .addWeapon(WeaponComponents.MarsPatternMacrocannons(Quality.GOOD), WeaponSlot.PROW)
                .addWeapon(WeaponComponents.MarsPatternMacrocannons(Quality.GOOD), WeaponSlot.PORT)
                .addWeapon(WeaponComponents.MarsPatternMacrocannons(Quality.GOOD), WeaponSlot.STARBOARD);

        System.out.println(jericho);
    }
}
