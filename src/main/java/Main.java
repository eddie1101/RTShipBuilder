public class Main {
    public static void main(String[] args) {
        Ship jericho = new ShipJerichoTransport("Resolute");
        jericho.addModifier(stats -> {
            stats.setPower(45);
        });

        System.out.println(jericho);
    }
}
