package week9;

import java.util.Locale;
import java.util.Scanner;

public class q5 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int applianceCount = scanner.nextInt();
            double totalCost = 0.0;

            for (int i = 0; i < applianceCount; i++) {
                String type = scanner.next().toUpperCase(Locale.ROOT);
                double hours = scanner.nextDouble();
                boolean saverRequested = scanner.hasNext("(?i)SAVER");
                if (saverRequested) {
                    scanner.next();
                }

                Appliance appliance;
                if (type.equals("FRIDGE")) {
                    appliance = new Fridge();
                } else if (type.equals("AC")) {
                    appliance = new AirConditioner();
                } else if (type.equals("TV")) {
                    appliance = new Television();
                } else if (type.equals("WASHER")) {
                    appliance = new WashingMachine();
                } else {
                    throw new IllegalArgumentException("Unknown appliance: " + type);
                }

                if (saverRequested && !(appliance instanceof SaverMode)) {
                    System.out.println(type + ": saver mode not supported");
                    continue;
                }

                double units = appliance.unitsUsed(hours);
                if (saverRequested) {
                    units = ((SaverMode) appliance).applySaverMode(units);
                }
                double cost = units * Appliance.COST_PER_UNIT;
                System.out.printf(Locale.US, "%s: Units=%.2f Cost=%.2f%n", type, units, cost);
                totalCost += cost;
            }

            System.out.printf(Locale.US, "Total Cost: %.2f%n", totalCost);
        }
    }

    private abstract static class Appliance {
        private static final double COST_PER_UNIT = 8.0;

        protected abstract double powerWatts();

        private double unitsUsed(double hours) {
            return powerWatts() * hours / 1000.0;
        }
    }

    private interface SaverMode {
        default double applySaverMode(double units) {
            return units * 0.75;
        }
    }

    private static class Fridge extends Appliance {
        @Override
        protected double powerWatts() {
            return 150.0;
        }
    }

    private static class AirConditioner extends Appliance implements SaverMode {
        @Override
        protected double powerWatts() {
            return 1500.0;
        }
    }

    private static class Television extends Appliance {
        @Override
        protected double powerWatts() {
            return 100.0;
        }
    }

    private static class WashingMachine extends Appliance implements SaverMode {
        @Override
        protected double powerWatts() {
            return 500.0;
        }
    }
}
