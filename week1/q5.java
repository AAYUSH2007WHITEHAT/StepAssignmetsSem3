package week1;

public class q5 {
    public void classifyWordLengths(String review) {
        int shortWords = 0;
        int mediumWords = 0;
        int longWords = 0;
        String trimmedReview = review.trim();

        if (!trimmedReview.isEmpty()) {
            String[] words = trimmedReview.split("\\s+");

            for (String word : words) {
                int wordLength = word.length();

                if (wordLength <= 4) {
                    shortWords++;
                } else if (wordLength <= 8) {
                    mediumWords++;
                } else {
                    longWords++;
                }
            }
        }

        System.out.printf("Short: %d | Medium: %d | Long: %d%n",
                shortWords, mediumWords, longWords);
    }
}
