package week8;

import java.util.*;

interface Delivery {
    double calculateFee();
}

class Standard implements Delivery {
    double weight;
    double distance;

    Standard(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    public double calculateFee() {
        return 5 + 0.50 * weight + 0.10 * distance;
    }
}

class Express implements Delivery {
    double weight;
    double distance;

    Express(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    public double calculateFee() {
        return 15 + 1.00 * weight + 0.20 * distance;
    }
}

class International implements Delivery {
    double weight;
    double distance;
    double customsFee;

    International(double weight, double distance, double customsFee) {
        this.weight = weight;
        this.distance = distance;
        this.customsFee = customsFee;
    }

    public double calculateFee() {
        return 25 + 2.00 * weight + 0.50 * distance + customsFee;
    }
}

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();

            Delivery delivery;

            if (type.equals("STANDARD")) {
                double weight = sc.nextDouble();
                double distance = sc.nextDouble();

                delivery = new Standard(weight, distance);
            }
            else if (type.equals("EXPRESS")) {
                double weight = sc.nextDouble();
                double distance = sc.nextDouble();

                delivery = new Express(weight, distance);
            }
            else {
                double weight = sc.nextDouble();
                double distance = sc.nextDouble();
                double customsFee = sc.nextDouble();

                delivery = new International(weight, distance, customsFee);
            }

            double fee = delivery.calculateFee();

            System.out.printf("%s: %.2f%n", type, fee);

            total += fee;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}