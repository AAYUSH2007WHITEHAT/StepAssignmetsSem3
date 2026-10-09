package week1;

public class q4 {
    public void analyzeInventory(int[] sectionA, int[] sectionB) {
        if (sectionA.length != sectionB.length) {
            System.out.println("Section arrays must have equal lengths");
            return;
        }

        int totalA = 0;
        int totalB = 0;

        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            totalB += sectionB[i];
        }

        String status = totalA == totalB ? "Balanced" : "Not Balanced";

        if (sectionA.length == 0) {
            System.out.printf("Section A Total: %d | Section B Total: %d | Status: %s"
                            + " | Highest Quantity: No Items%n",
                    totalA, totalB, status);
            return;
        }

        int highestQuantity = sectionA[0];
        String highestSection = "Section A";
        int highestIndex = 0;

        for (int i = 1; i < sectionA.length; i++) {
            if (sectionA[i] > highestQuantity) {
                highestQuantity = sectionA[i];
                highestSection = "Section A";
                highestIndex = i;
            }
        }

        for (int i = 0; i < sectionB.length; i++) {
            if (sectionB[i] > highestQuantity) {
                highestQuantity = sectionB[i];
                highestSection = "Section B";
                highestIndex = i;
            }
        }

        System.out.printf("Section A Total: %d | Section B Total: %d | Status: %s"
                        + " | Highest Quantity: %d (%s, Item %d)%n",
                totalA, totalB, status, highestQuantity, highestSection, highestIndex + 1);
    }
}
