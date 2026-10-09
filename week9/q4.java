package week9;

import java.util.Locale;
import java.util.Scanner;

public class q4 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int tripCount = scanner.nextInt();
            double total = 0.0;

            for (int i = 0; i < tripCount; i++) {
                String type = scanner.next().toUpperCase(Locale.ROOT);
                double distanceKm = scanner.nextDouble();
                String time = scanner.next().toUpperCase(Locale.ROOT);
                Cab cab;

                if (type.equals("MINI")) {
                    cab = new MiniCab();
                } else if (type.equals("SEDAN")) {
                    cab = new SedanCab();
                } else if (type.equals("SUV")) {
                    cab = new SuvCab();
                } else {
                    throw new IllegalArgumentException("Unknown cab type: " + type);
                }

                if (time.equals("NIGHT") && !(cab instanceof NightService)) {
                    System.out.println(type + ": night service not available");
                    continue;
                }

                double fare = cab.fare(distanceKm);
                if (time.equals("NIGHT")) {
                    fare = ((NightService) cab).applyNightFare(fare);
                }

                System.out.printf(Locale.US, "%s: %.2f%n", type, fare);
                total += fare;
            }

            System.out.printf(Locale.US, "Total: %.2f%n", total);
        }
    }

    private abstract static class Cab {
        private static final double MINIMUM_FARE = 100.0;

        protected abstract double ratePerKm();

        private double fare(double distanceKm) {
            return Math.max(distanceKm * ratePerKm(), MINIMUM_FARE);
        }
    }

    private interface NightService {
        default double applyNightFare(double fare) {
            return fare * 1.20;
        }
    }

    private static class MiniCab extends Cab {
        @Override
        protected double ratePerKm() {
            return 10.0;
        }
    }

    private static class SedanCab extends Cab implements NightService {
        @Override
        protected double ratePerKm() {
            return 14.0;
        }
    }

    private static class SuvCab extends Cab implements NightService {
        @Override
        protected double ratePerKm() {
            return 18.0;
        }
    }
}
