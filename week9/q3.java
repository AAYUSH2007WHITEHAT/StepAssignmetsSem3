package week9;

import java.util.Locale;
import java.util.Scanner;

public class q3 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int studentCount = scanner.nextInt();
            double totalCollected = 0.0;

            for (int i = 0; i < studentCount; i++) {
                String type = scanner.next().toUpperCase(Locale.ROOT);
                String name = scanner.next();
                Student student;

                if (type.equals("DAY_SCHOLAR")) {
                    student = new DayScholar(name);
                } else if (type.equals("HOSTELLER")) {
                    student = new Hosteller(name);
                } else if (type.equals("SCHOLAR")) {
                    student = new ScholarshipStudent(name);
                } else {
                    throw new IllegalArgumentException("Unknown student type: " + type);
                }

                double fee = student.totalFee();
                System.out.printf(Locale.US, "%s: %.2f%n", student.name(), fee);
                totalCollected += fee;
            }

            System.out.printf(Locale.US, "Total Collected: %.2f%n", totalCollected);
        }
    }

    private abstract static class Student {
        private final String name;

        private Student(String name) {
            this.name = name;
        }

        private String name() {
            return name;
        }

        protected abstract double tuitionFee();

        private double totalFee() {
            double transportFee = this instanceof BusUser ? BusUser.TRANSPORT_FEE : 0.0;
            return tuitionFee() + transportFee;
        }
    }

    private interface BusUser {
        double TRANSPORT_FEE = 12000.0;
    }

    private static class DayScholar extends Student implements BusUser {
        private DayScholar(String name) {
            super(name);
        }

        @Override
        protected double tuitionFee() {
            return 40000.0;
        }
    }

    private static class Hosteller extends Student {
        private Hosteller(String name) {
            super(name);
        }

        @Override
        protected double tuitionFee() {
            return 40000.0 + 60000.0;
        }
    }

    private static class ScholarshipStudent extends Student implements BusUser {
        private ScholarshipStudent(String name) {
            super(name);
        }

        @Override
        protected double tuitionFee() {
            return 20000.0;
        }
    }
}
