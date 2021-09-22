import component.components.EssentialComponents;
import component.components.SupplementalComponents;
import ship.Ship;
import ship.ShipJerichoTransport;

public class Main {

    public static void main(String[] args) {
        Ship jericho = new ShipJerichoTransport("Crypt")
                .addComponent(EssentialComponents.LathePattern2A())
                .addComponent(EssentialComponents.Strelov1())
                .addComponent(EssentialComponents.GellerField())
                .addComponent(EssentialComponents.SingleVoidShieldArray())
                .addComponent(EssentialComponents.CombatBridge())
                .addComponent(EssentialComponents.VitaePatternLifeSustainer())
                .addComponent(EssentialComponents.VoidsmenQuarters())
                .addComponent(EssentialComponents.m201b())
                .addSupplementalComponents(SupplementalComponents.ArmorPlating(), 4);

        System.out.println(jericho);
    }
}
