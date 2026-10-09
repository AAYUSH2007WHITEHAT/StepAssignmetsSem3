package week1;

public class q2 {
    public void checkTypingAccuracy(String original, String typed) {
        int matchedCharacters = 0;
        int firstMismatch = -1;
        int comparedLength = Math.min(original.length(), typed.length());

        for (int i = 0; i < comparedLength; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matchedCharacters++;
            } else if (firstMismatch == -1) {
                firstMismatch = i;
            }
        }

        int totalCharacters = Math.max(original.length(), typed.length());
        double accuracy = totalCharacters == 0
                ? 100.0
                : matchedCharacters * 100.0 / totalCharacters;

        System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | ",
                matchedCharacters, totalCharacters, accuracy);

        if (firstMismatch == -1 && original.length() == typed.length()) {
            System.out.println("No Mismatches");
        } else if (firstMismatch != -1) {
            System.out.printf("First Mismatch at position %d ('%s' vs '%s')%n",
                    firstMismatch + 1,
                    displayCharacter(original, firstMismatch),
                    displayCharacter(typed, firstMismatch));
        } else {
            int mismatchPosition = comparedLength;
            System.out.printf("First Mismatch at position %d ('%s' vs '%s')%n",
                    mismatchPosition + 1,
                    displayCharacter(original, mismatchPosition),
                    displayCharacter(typed, mismatchPosition));
        }
    }

    private String displayCharacter(String text, int index) {
        return index < text.length() ? String.valueOf(text.charAt(index)) : "<end>";
    }
}
