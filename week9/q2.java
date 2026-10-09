package week9;

import java.util.Locale;
import java.util.Scanner;

public class q2 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int parcelCount = scanner.nextInt();
            double grandTotal = 0.0;

            for (int i = 0; i < parcelCount; i++) {
                String type = scanner.next().toUpperCase(Locale.ROOT);
                double weightKg = scanner.nextDouble();
                double declaredValue = scanner.nextDouble();
                Parcel parcel;

                if (type.equals("STANDARD")) {
                    parcel = new StandardParcel(weightKg);
                } else if (type.equals("EXPRESS")) {
                    parcel = new ExpressParcel(weightKg);
                } else if (type.equals("FRAGILE")) {
                    parcel = new FragileParcel(weightKg);
                } else {
                    throw new IllegalArgumentException("Unknown parcel type: " + type);
                }

                double charge = parcel.shippingCharge();
                double insurance = parcel.insuranceFor(declaredValue);
                double total = charge + insurance;
                System.out.printf(Locale.US,
                        "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                        type, charge, insurance, total);
                grandTotal += total;
            }

            System.out.printf(Locale.US, "Grand Total: %.2f%n", grandTotal);
        }
    }

    private abstract static class Parcel {
        private final double weightKg;

        private Parcel(double weightKg) {
            this.weightKg = weightKg;
        }

        protected double weightKg() {
            return weightKg;
        }

        protected abstract double shippingCharge();

        private double insuranceFor(double declaredValue) {
            if (this instanceof Insurable) {
                return ((Insurable) this).insuranceAmount(declaredValue);
            }
            return 0.0;
        }
    }

    private interface Insurable {
        double insuranceAmount(double declaredValue);
    }

    private static class StandardParcel extends Parcel {
        private StandardParcel(double weightKg) {
            super(weightKg);
        }

        @Override
        protected double shippingCharge() {
            return 40.0 + 10.0 * weightKg();
        }
    }

    private static class ExpressParcel extends Parcel implements Insurable {
        private ExpressParcel(double weightKg) {
            super(weightKg);
        }

        @Override
        protected double shippingCharge() {
            return 80.0 + 15.0 * weightKg();
        }

        @Override
        public double insuranceAmount(double declaredValue) {
            return declaredValue * 0.02;
        }
    }

    private static class FragileParcel extends StandardParcel implements Insurable {
        private FragileParcel(double weightKg) {
            super(weightKg);
        }

        @Override
        protected double shippingCharge() {
            return super.shippingCharge() + 50.0;
        }

        @Override
        public double insuranceAmount(double declaredValue) {
            return declaredValue * 0.02;
        }
    }
}
