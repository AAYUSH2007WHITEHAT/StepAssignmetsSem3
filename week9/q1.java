package week9;

import java.util.Locale;
import java.util.Scanner;

public class q1 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int bookings = scanner.nextInt();
            double total = 0.0;

            for (int i = 0; i < bookings; i++) {
                String seatType = scanner.next().toUpperCase(Locale.ROOT);
                int count = scanner.nextInt();
                Ticket ticket;

                if (seatType.equals("REGULAR")) {
                    ticket = new RegularTicket();
                } else if (seatType.equals("PREMIUM")) {
                    ticket = new PremiumTicket();
                } else if (seatType.equals("RECLINER")) {
                    ticket = new ReclinerTicket();
                } else {
                    throw new IllegalArgumentException("Unknown seat type: " + seatType);
                }

                double amount = ticket.bookingAmount(count);
                System.out.printf(Locale.US, "%s: %.2f%n", seatType, amount);
                total += amount;
            }

            System.out.printf(Locale.US, "Total: %.2f%n", total);
        }
    }

    private abstract static class Ticket {
        private static final double CONVENIENCE_FEE = 20.0;

        protected abstract double ticketPrice();

        private double bookingAmount(int count) {
            return count * (ticketPrice() + CONVENIENCE_FEE);
        }
    }

    private static class RegularTicket extends Ticket {
        @Override
        protected double ticketPrice() {
            return 150.0;
        }
    }

    private static class PremiumTicket extends Ticket {
        @Override
        protected double ticketPrice() {
            return 250.0;
        }
    }

    private static class ReclinerTicket extends Ticket {
        @Override
        protected double ticketPrice() {
            return 400.0;
        }
    }
}
