package week8;

import java.util.*;
import java.time.*;

interface LibraryItem {
    LocalDate getDueDate();
}

class Book implements LibraryItem {
    public LocalDate getDueDate() {
        return LocalDate.of(2023, 10, 26).plusDays(14);
    }
}

class DVD implements LibraryItem {
    public LocalDate getDueDate() {
        return LocalDate.of(2023, 10, 26).plusDays(7);
    }
}

class Magazine implements LibraryItem {
    public LocalDate getDueDate() {
        return LocalDate.of(2023, 10, 26).plusDays(3);
    }
}

public class q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();

            String type = line.substring(0, line.indexOf(" "));
            String title = line.substring(line.indexOf(" ") + 1);

            title = title.replace("\"", "");

            LibraryItem item;

            if (type.equals("BOOK")) {
                item = new Book();
            }
            else if (type.equals("DVD")) {
                item = new DVD();
            }
            else {
                item = new Magazine();
            }

            System.out.println(title + ": " + item.getDueDate());
        }
    }
}