package week1;

public class q1 {
    public void checkDuplicateSeats(int[] seatNumbers) {
        boolean duplicateFound = false;

        for (int i = 0; i < seatNumbers.length; i++) {
            boolean alreadyReported = false;
            for (int previous = 0; previous < i; previous++) {
                if (seatNumbers[i] == seatNumbers[previous]) {
                    alreadyReported = true;
                    break;
                }
            }

            if (!alreadyReported) {
                for (int next = i + 1; next < seatNumbers.length; next++) {
                    if (seatNumbers[i] == seatNumbers[next]) {
                        if (duplicateFound) {
                            System.out.print(", ");
                        } else {
                            System.out.print("Duplicate Seat Number Found: ");
                        }
                        System.out.print(seatNumbers[i]);
                        duplicateFound = true;
                        break;
                    }
                }
            }
        }

        if (!duplicateFound) {
            System.out.println("No Duplicate Seats Found");
        } else {
            System.out.println();
        }
    }
}
