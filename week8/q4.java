package week8;

import java.util.*;

interface Question {
    double grade();
}

class MCQ implements Question {
    String correct;
    String student;
    double points;

    MCQ(String correct, String student, double points) {
        this.correct = correct;
        this.student = student;
        this.points = points;
    }

    public double grade() {
        if (correct.equalsIgnoreCase(student)) {
            return points;
        }

        return 0;
    }
}

class TF implements Question {
    String correct;
    String student;
    double points;

    TF(String correct, String student, double points) {
        this.correct = correct;
        this.student = student;
        this.points = points;
    }

    public double grade() {
        if (correct.equalsIgnoreCase(student)) {
            return points;
        }

        return 0;
    }
}

class Essay implements Question {
    String correct;
    String student;
    double points;

    Essay(String correct, String student, double points) {
        this.correct = correct;
        this.student = student;
        this.points = points;
    }

    public double grade() {
        String answer = student.toLowerCase();

        String[] keywords = correct.split(",");

        int count = 0;

        for (String keyword : keywords) {
            if (answer.contains(keyword.trim().toLowerCase())) {
                count++;
            }
        }

        if (count >= 2) {
            return points * 0.75;
        }
        else if (count == 1) {
            return points * 0.50;
        }

        return 0;
    }
}

public class q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        double total = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();

            String[] parts = line.split("\"");

            String type = parts[0].trim();
            String correct = parts[3];
            String student = parts[5];
            double points = Double.parseDouble(parts[6].trim());

            Question question;

            if (type.equals("MCQ")) {
                question = new MCQ(correct, student, points);
            }
            else if (type.equals("TF")) {
                question = new TF(correct, student, points);
            }
            else {
                question = new Essay(correct, student, points);
            }

            double score = question.grade();

            System.out.printf("%s: %.2f%n", type, score);

            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);
    }
}