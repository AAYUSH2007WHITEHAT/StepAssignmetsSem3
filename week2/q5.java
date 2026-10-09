package week2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class q5 {
    public void printFilteredWordFrequency(String feedback) {
        String cleanedFeedback = feedback.toLowerCase()
                .replace(".", "")
                .replace(",", "")
                .trim();
        Map<String, Integer> wordFrequencies = new HashMap<>();
        String[] stopWords = {"the", "was", "and", "a", "is", "of", "in"};

        if (!cleanedFeedback.isEmpty()) {
            String[] words = cleanedFeedback.split("\\s+");

            for (String word : words) {
                if (!isStopWord(word, stopWords)) {
                    wordFrequencies.put(word, wordFrequencies.getOrDefault(word, 0) + 1);
                }
            }
        }

        List<Map.Entry<String, Integer>> frequencies =
                new ArrayList<>(wordFrequencies.entrySet());
        frequencies.sort((first, second) -> second.getValue().compareTo(first.getValue()));

        for (Map.Entry<String, Integer> frequency : frequencies) {
            System.out.println(frequency.getKey() + ": " + frequency.getValue());
        }
    }

    private boolean isStopWord(String word, String[] stopWords) {
        for (String stopWord : stopWords) {
            if (word.equals(stopWord)) {
                return true;
            }
        }
        return false;
    }
}
